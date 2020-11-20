package com.panda.serviceimpl.authority;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.panda.dao.mapper.UmsAdminMapper;
import com.panda.dao.user.UmsAdminRoleRelationDao;
import com.panda.entity.UmsAdminEntity;
import com.panda.entity.UmsPermissionEntity;
import com.panda.service.authority.UmsAdminService;


//@Service("umsAdminService")
public class UmsAdminServiceImpl implements UmsAdminService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    
	//@Autowired
    private UserDetailsService userDetailsService;
    //@Autowired
    private JwtTokenUtil jwtTokenUtil;
    //@Autowired
    private PasswordEncoder passwordEncoder;
   // @Value("${jwt.tokenHead}")
    private String tokenHead;
    //@Autowired
    private UmsAdminMapper adminMapper;
    //@Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    
    @Override
    public UmsAdminEntity getAdminByUsername(String username) {
		/*
		 * UmsAdminExample example = new UmsAdminExample();
		 * example.createCriteria().andUsernameEqualTo(username); List<UmsAdmin>
		 * adminList = adminMapper.selectByExample(example); if (adminList != null &&
		 * adminList.size() > 0) { return adminList.get(0); }
		 */
        return null;
    }

    @Override
    public UmsAdminEntity register(UmsAdminEntity umsAdminParam) {
    	UmsAdminEntity umsAdmin = new UmsAdminEntity();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
		/*
		 * UmsAdminExample example = new UmsAdminExample();
		 * example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
		 * List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example); if
		 * (umsAdminList.size() > 0) { return null; }
		 */
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
		/* adminMapper.insert(umsAdmin); */
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
//                throw new BadCredentialsException("密码不正确");
//            }
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }


    @Override
    public List<UmsPermissionEntity> getPermissionList(Long adminId) {
        return null ; //adminRoleRelationDao.getPermissionList(adminId);
    }

}
