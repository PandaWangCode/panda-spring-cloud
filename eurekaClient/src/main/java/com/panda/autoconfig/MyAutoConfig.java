package com.panda.autoconfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.panda.utils_test.ConditionalClass1;


@Configuration
@ConditionalOnClass(ConditionalClass1.class)
public class MyAutoConfig {
	
	@Bean
	public MyConfig getMyConfigBean() {
		return new MyConfig();
	}
	
}
