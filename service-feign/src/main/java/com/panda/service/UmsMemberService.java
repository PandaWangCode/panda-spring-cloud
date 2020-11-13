package com.panda.service;

import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "UmsMemberService", description = "��֤��У��ӿ�")
public interface UmsMemberService {
	
	@ApiOperation("������֤��")
    Map<String, Object> generateAuthCode(String telephone);

	@ApiOperation("�ж���֤����ֻ������Ƿ�ƥ��")
    Map<String, Object> verifyAuthCode(String telephone, String authCode);
    
}
