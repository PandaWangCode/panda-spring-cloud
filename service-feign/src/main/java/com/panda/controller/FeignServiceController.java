package com.panda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.panda.service.SchedualSayHiFeignService;
import com.panda.serviceimpl_hystrix.SchedualSayHiFeignServiceimplHystrix;


@RestController
public class FeignServiceController {
	
	@Autowired
	SchedualSayHiFeignService schedualSayHiFeignService;
	
	@GetMapping("/feign/hi")
	public String home(@RequestParam String name) {
		return schedualSayHiFeignService.sayHiFromClient2(name);
	}

}
