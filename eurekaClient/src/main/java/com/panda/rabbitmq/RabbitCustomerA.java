package com.panda.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.a")
public class RabbitCustomerA {
	
	@RabbitHandler
	public void ReceiverA(String queString){
		System.out.println("Received :"+queString);
	}

}
