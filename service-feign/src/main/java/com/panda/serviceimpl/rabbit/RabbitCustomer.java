package com.panda.serviceimpl.rabbit;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "com.panda.direct")
public class RabbitCustomer {
	
	@RabbitHandler
	public void ReceiverA(String queString){
		System.out.println("Feign Service 端，收到消息:"+queString);
	}	
}
