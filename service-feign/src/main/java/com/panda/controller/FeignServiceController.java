package com.panda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.panda.service.SchedualSayHiFeignService;


@RestController
public class FeignServiceController {
	
	@Autowired
	SchedualSayHiFeignService schedualSayHiFeignService;
	
	@GetMapping("/feign/hi")
	public String home(@RequestParam String name) {
		return schedualSayHiFeignService.sayHiFromClient2(name);
	}
	
}
