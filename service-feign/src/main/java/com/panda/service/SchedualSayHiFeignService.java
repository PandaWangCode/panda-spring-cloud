package com.panda.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.panda.serviceimpl.hystrix.SchedualSayHiFeignServiceimplHystrix;



/**
 * FeignClient 在Servie层建立和调用的客户端一一对应的RUL地址对应关系，
 * 稍后Controller请求的时候，会重选替换掉其中的地址进行请求
 * value : 调用的服务器名
 * fallback :断路器，执行调用失败后，处理失败的调用类
 * @author wangpan
 */
@FeignClient(value = "service-eureka-client", fallback = SchedualSayHiFeignServiceimplHystrix.class)
public interface SchedualSayHiFeignService {
	
	@GetMapping("/eurekaclient/hi")
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
	
	@GetMapping("/eurekaclient/hi")
	String sayHiFromClient2(@RequestParam(value = "name") String name);
}
