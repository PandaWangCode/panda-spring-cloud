package com.panda.rabbitmq.a;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitCustomerA {
	
	@RabbitListener(queues = "queue.topic.a")
	public void receiverA(String queString){
		System.out.println("Received A :"+queString);
	}
	
	@RabbitListener(queues = "queue.topic.b")
	public void receiverB(String queString){
		System.out.println("Received B :"+queString);
	}

}
