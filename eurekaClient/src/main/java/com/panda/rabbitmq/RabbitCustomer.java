package com.panda.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitmqConfig.QUEUE_DIRECT_NAME)
public class RabbitCustomer {
	
	@RabbitHandler
	public void ReceiverA(String queString){
		System.out.println("收到消息:"+queString);
	}

}
