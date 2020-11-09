package com.panda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceRibbonApplication {
	
	/**
	 * ͨ��@EnableDiscoveryClient���������ע�᣻����������iocע��һ��bean: restTemplate;
	 * ��ͨ��@LoadBalancedע��������Ǹ�restRemplate�������ؾ���Ĺ��ܡ�
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	};
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
		System.out.println("=============Service-Ribbon已经启动================");
	}
	
	
}
