package com.panda.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.b")
public class RabbitCustomerA_1 {
	
	@RabbitHandler
	public void ReceiverA(String queString){
		System.out.println("Received :"+queString);
	}

}
