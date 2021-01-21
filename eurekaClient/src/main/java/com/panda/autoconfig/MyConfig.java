package com.panda.autoconfig;

import org.springframework.transaction.annotation.Transactional;

public class MyConfig {
   
	@Transactional
	public String getMyConfig() {
		return "MyConfig";
	}
	
}
