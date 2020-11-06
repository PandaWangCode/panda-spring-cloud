package com.panda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.panda.service.RibbonService;


@RestController
@RequestMapping(value = "/ribbon")
public class ribbonController {
	
	@Autowired
	private RibbonService ribbonService;
	
	@GetMapping("/hi")
	public String home(@RequestParam String name) {
		return ribbonService.getRestTemplate(name);
	}

}
