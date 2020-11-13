package com.panda.serviceimpl.authority;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.panda.entity.UmsAdminEntity;
import com.panda.entity.UmsPermissionEntity;
import com.panda.service.authority.UmsAdminService;

/*
 * configure(HttpSecurity httpSecurity)������������Ҫ���ص�url·����jwt�����������쳣��Ĵ�������
 * configure(AuthenticationManagerBuilderauth)����������UserDetailsService��PasswordEncoder��
 * RestfulAccessDeniedHandler�����û�û�з���Ȩ��ʱ�Ĵ����������ڷ���JSON��ʽ�Ĵ�������
 * RestAuthenticationEntryPoint����δ��¼��tokenʧЧʱ������JSON��ʽ�Ľ����
 * UserDetailsService:SpringSecurity����ĺ��Ľӿڣ����ڸ����û�����ȡ�û���Ϣ����Ҫ����ʵ�֣�
 * UserDetails��SpringSecurity�������ڷ�װ�û���Ϣ���ࣨ��Ҫ���û���Ϣ��Ȩ�ޣ�����Ҫ����ʵ�֣�
 * PasswordEncoder��SpringSecurity��������ڶ�������б��뼰�ȶԵĽӿڣ�Ŀǰʹ�õ���BCryptPasswordEncoder��
 * JwtAuthenticationTokenFilter�����û���������У��ǰ��ӵĹ������������jwt��token�������и���token��Ϣ���е�¼��
 */

/**
 * Spring Security ����
 * @author wangpan
 *
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	  @Autowired 
	  private UmsAdminService adminService; //�û�
	  
	  @Autowired 
	  private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
	  
	  @Autowired 
	  private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	 
	 @Override
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.csrf()// ����ʹ�õ���JWT���������ﲻ��Ҫcsrf
	                .disable()
	                .sessionManagement()// ����token�����Բ���Ҫsession
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET, // ���������վ��̬��Դ������Ȩ����
	                        "/",
	                        "/*.html",
	                        "/favicon.ico",
	                        "/**/*.html",
	                        "/**/*.css",
	                        "/**/*.js",
	                        "/swagger-resources/**",
	                        "/v2/api-docs/**"
	                )
	                .permitAll()
	                .antMatchers("/admin/login", "/admin/register")// �Ե�¼ע��Ҫ������������
	                .permitAll()
	                .antMatchers(HttpMethod.OPTIONS)//����������Ƚ���һ��options����
	                .permitAll()
//	                .antMatchers("/**")//����ʱȫ�����з���
//	                .permitAll()
	                .anyRequest()// �����������������ȫ����Ҫ��Ȩ��֤
	                .authenticated();
	        // ���û���
	        httpSecurity.headers().cacheControl();
	        // ���JWT filter
	        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class); 
	        //����Զ���δ��Ȩ��δ��¼�������
	        httpSecurity.exceptionHandling()
	                .accessDeniedHandler(restfulAccessDeniedHandler)
	                .authenticationEntryPoint(restAuthenticationEntryPoint);
	    }
	 
	 	/**
	 	 * ���û���������У��ǰ��ӵĹ������������jwt��token�������и���token��Ϣ���е�¼
	 	 * @return
	 	 */
	    @Bean
	    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
	        return new JwtAuthenticationTokenFilter();
	    }
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public UserDetailsService userDetailsService() {
	        //��ȡ��¼�û���Ϣ
	        return username -> {
	            UmsAdminEntity admin = adminService.getAdminByUsername(username);
	            if (admin != null) {
	                List<UmsPermissionEntity> permissionList = adminService.getPermissionList(admin.getId());
	                return new AdminUserDetails(admin,permissionList);
	            }
	            throw new UsernameNotFoundException("�û������������");
	        };
	    }
	    
	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
    
}
