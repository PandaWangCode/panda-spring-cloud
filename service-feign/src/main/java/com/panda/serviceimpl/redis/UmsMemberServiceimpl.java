package com.panda.serviceimpl.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ctc.wstx.util.StringUtil;
import com.panda.service.RedisService;
import com.panda.service.UmsMemberService;

@Service("umsMemberService")
public class UmsMemberServiceimpl implements UmsMemberService{
	
	@Autowired
	RedisService redisService;
	
	@Value("${redis.key.prefix.authCode}")
	private String REDIS_KEY_PREFIX_AUTH_CODE;
	
	@Value("${redis.key.expire.authCode}")
	private Long AUTH_CODE_EXPIRE_SECONDS;
	
	@Override
	public Map<String, Object> generateAuthCode(String telephone) {
		Map<String, Object> authMapsMap = new HashMap<>();
		StringBuilder sBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sBuilder.append(random.nextInt(10));
		}
		authMapsMap.put("flag", true);
		authMapsMap.put("message", "��֤�����ɳɹ�");
		authMapsMap.put("authCode", sBuilder.toString());
		
		// ��֤��+�ֻ��� �洢��redis
		redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone, sBuilder.toString());	
		//����Redis����ʱ��
		redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone, AUTH_CODE_EXPIRE_SECONDS);
		return authMapsMap;
	}

	@Override
	public Map<String, Object> verifyAuthCode(String telephone, String authCode) {
		Map<String, Object> authCodeMaps = new HashMap<>();
		if (org.springframework.util.StringUtils.isEmpty(authCode)) {
			authCodeMaps.put("flag", false);
			authCodeMaps.put("message", "��֤�벻��Ϊ��");
		}
		String authCodeStr = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
		if (authCode.equals(authCodeStr)) {
			authCodeMaps.put("flag", true);
			authCodeMaps.put("message", "У��ɹ�");
		} else {
			authCodeMaps.put("flag", false);
			authCodeMaps.put("message", "��֤�벻��ȷ");
		}
		return authCodeMaps;
	}

}
