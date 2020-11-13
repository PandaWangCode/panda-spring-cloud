package com.panda.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.panda.service.UmsMemberService;

import io.swagger.annotations.Api;

@Api(tags = "UmsMemberController", description = "验证码校验接口")
@RestController
public class UmsMemberController {
	
	@Autowired
	UmsMemberService umsMemberService;

	@GetMapping("/soo/getAuthCode")
	@ResponseBody
	public String getAuthCode(@RequestParam String telephone) {
		Map<String, Object> authCodeMaps = new HashMap<>();
		authCodeMaps = umsMemberService.generateAuthCode(telephone);
		System.out.println("验证码生成");
		return authCodeMaps.get("flag").toString() +":"+ authCodeMaps.get("message").toString()
				+ ":验证码是：:"+ authCodeMaps.get("authCode").toString();
	}
	
	@GetMapping("/soo/checkAuthCode")
	@ResponseBody
	public String checkAuthCode(@RequestParam String telephone, @RequestParam String authCode) {
		Map<String, Object> checkMaps = new HashMap<>();
		checkMaps = umsMemberService.verifyAuthCode(telephone, authCode);
		return checkMaps.get("flag").toString() +":"+ checkMaps.get("message").toString();
	}
}
