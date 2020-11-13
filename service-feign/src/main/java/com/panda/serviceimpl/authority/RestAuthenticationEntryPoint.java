package com.panda.serviceimpl.authority;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import cn.hutool.json.JSONUtil;

/**
 * 当未登录或token失效时，返回JSON格式的结果；
 * @author wangpan
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, 
			             HttpServletResponse response,
			             AuthenticationException authException) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("code", "403");
        resMap.put("message", authException.getMessage());
        response.getWriter().println(JSONUtil.parse(resMap));
        response.getWriter().flush();
		
	}

}
