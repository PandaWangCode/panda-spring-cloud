package com.panda.service;

import java.util.Map;

public interface UmsMemberService {
	/**
     * 生成验证码
     */
    Map<String, Object> generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    Map<String, Object> verifyAuthCode(String telephone, String authCode);
    
}
