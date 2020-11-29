package com.panda.serviceimpl.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

@Component
public class UserLogProducter {
   
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendLog(String userId) {
		Userlog userlog = new Userlog();
		userlog.setUserId(userId);
		userlog.setUserName("王攀");
		userlog.setState("用户信息");
		System.out.println(userlog + "  1");
		kafkaTemplate.send("userLog",  JSON.toJSONString(userlog));
	}
	
}
