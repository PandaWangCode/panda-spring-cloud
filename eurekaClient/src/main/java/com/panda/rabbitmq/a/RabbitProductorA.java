package com.panda.rabbitmq.a;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProductorA {
	
  @Autowired
  private AmqpTemplate amqpTemplate;
  
  public void sendMessage1() {
	  String context = "topic";
	  System.out.println("Sender Message£º"+context);
	  amqpTemplate.convertAndSend(RabbitmqConfigA.EXCHANGE_TOPIC, "queue.topic.a", context);
  }
  
  public void sendMessage2() {
	  String context = "topic 2";
	  System.out.println("Sender Message£º"+context);
	  amqpTemplate.convertAndSend(RabbitmqConfigA.EXCHANGE_TOPIC, "queue.topic.a", context);
  }
  
  public void sendMessage3() {
	  String context = "topic 3";
	  System.out.println("Sender Message£º"+context);
	  amqpTemplate.convertAndSend(RabbitmqConfigA.EXCHANGE_TOPIC, "queue.topic.b", context);
  }  
  
}
