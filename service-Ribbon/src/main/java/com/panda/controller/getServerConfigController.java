package com.panda.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/config")
public class getServerConfigController {
	
	@Value("${data.env}")
	private String envStr;
	
	@GetMapping("/getserverconfig")
	public String getServer() {
		System.out.println("data.envֵ============"+envStr);
		return envStr;
	}

}
