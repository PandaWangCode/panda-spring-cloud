package com.panda.service;

import java.util.Map;

public interface UmsMemberService {
	/**
     * ������֤��
     */
    Map<String, Object> generateAuthCode(String telephone);

    /**
     * �ж���֤����ֻ������Ƿ�ƥ��
     */
    Map<String, Object> verifyAuthCode(String telephone, String authCode);
    
}
