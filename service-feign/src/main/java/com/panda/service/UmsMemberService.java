package com.panda.service;

import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "UmsMemberService", description = "验证码校验接口")
public interface UmsMemberService {
	
	@ApiOperation("生成验证码")
    Map<String, Object> generateAuthCode(String telephone);

	@ApiOperation("判断验证码和手机号码是否匹配")
    Map<String, Object> verifyAuthCode(String telephone, String authCode);
    
}
