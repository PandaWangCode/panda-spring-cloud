package com.panda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.panda.service.SchedualSayHiFeignService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@Api(tags = "feignServiceController", description = "Feign����REST���ӿ�")
@RestController
public class FeignServiceController {
	
	@Autowired
	SchedualSayHiFeignService schedualSayHiFeignService;
	
	@ApiOperation("����Feign���÷���")
	@GetMapping("/feign/hi")
	public String home(@RequestParam String name) {
		return schedualSayHiFeignService.sayHiFromClient2(name);
	}
	
	@ApiModelProperty("�����־")
	public static String FILED_FLAG = "flag" ;
	
}
