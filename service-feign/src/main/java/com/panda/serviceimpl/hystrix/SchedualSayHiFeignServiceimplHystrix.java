package com.panda.serviceimpl.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.panda.service.SchedualSayHiFeignService;

@Component
public class SchedualSayHiFeignServiceimplHystrix implements SchedualSayHiFeignService {

	public String sayHiFromClientOne(String name) {
		return "sorry,"+name+"��Feign���÷���1Ӧ��ʧ�ܣ�";
	}

	public String sayHiFromClient2(String name) {
		return "sorry,"+name+"��Feign���÷���2Ӧ��ʧ�ܣ�";
	}
	
	/*
	 * @Autowired RestTemplate restTemplate;
	 * 
	 * public String getHiString(String name) { String resultString =
	 * restTemplate.getForObject(
	 * "http://SERVICE-EUREKA-CLIENT/eurekaclient/hi?name="+name, String.class);
	 * return resultString; }
	 */
}
