package com.panda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import araf.core.exception.BusinessException;

@EnableEurekaClient
@SpringBootApplication
public class EureakClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EureakClientApplication.class, args);
		System.out.println("=============Eureka�����ɹ�================");
	}
}
