package com.panda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public String getRestTemplate(String name) {
		return restTemplate.getForObject("http://SERVICE-EUREKA-CLIENT/eurekaclient/hi?name="+name, String.class);
	}

}
