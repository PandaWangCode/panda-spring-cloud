package com.panda.serviceimpl.authority;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import cn.hutool.json.JSONUtil;

/**
 * 当访问接口没有权限时，自定义的返回结果
 * @author DELL
 *
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, 
					   HttpServletResponse response,
					   AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("code", "403");
        resMap.put("message", accessDeniedException.getMessage());
        response.getWriter().println(JSONUtil.parse(resMap));
        response.getWriter().flush();
	}

}
