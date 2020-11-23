package com.panda.controller.rabbitmq;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panda.rabbitmq.RabbitProductor;
import com.panda.rabbitmq.a.RabbitProductorA;

@RestController
@RequestMapping(value = "/eurekaclient/rabbit")
public class RabbitMqController {
	
	@Autowired
	RabbitProductor rabbitProductor;
	
	@RequestMapping(value = "/sendmessage")
	private void testRabbitMqSend() {
		for (int i = 0; i < 10; i++) {
			String msgString = " message info " + i +new Date();
			rabbitProductor.sendMessage(msgString);
		}
	}	
	
	
	  @Autowired RabbitProductorA rabbitProductorA;
	  
	  @RequestMapping(value = "/sendmessageA") 
	  private void rabbitMqSendA() {
	    rabbitProductorA.sendMessage1(); 
	  }
	 
	
}
