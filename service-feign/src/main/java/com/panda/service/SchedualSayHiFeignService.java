package com.panda.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.panda.serviceimpl.hystrix.SchedualSayHiFeignServiceimplHystrix;



/**
 * FeignClient ��Servie�㽨���͵��õĿͻ���һһ��Ӧ��RUL��ַ��Ӧ��ϵ��
 * �Ժ�Controller�����ʱ�򣬻���ѡ�滻�����еĵ�ַ��������
 * value : ���õķ�������
 * fallback :��·����ִ�е���ʧ�ܺ󣬴���ʧ�ܵĵ�����
 * @author wangpan
 */
@FeignClient(value = "service-eureka-client", fallback = SchedualSayHiFeignServiceimplHystrix.class)
public interface SchedualSayHiFeignService {
	
	@GetMapping("/eurekaclient/hi")
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
	
	@GetMapping("/eurekaclient/hi")
	String sayHiFromClient2(@RequestParam(value = "name") String name);
}
