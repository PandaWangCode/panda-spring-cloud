package com.panda.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfigA {
	
	public static final String  EXCHANGE_TOPIC = "com.panda.exchange.topic";
	
	public static final String  ROUTING_KEY_A = "topic.a";
	public static final String  ROUTING_KEY_B = "topic.#";
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(EXCHANGE_TOPIC);
	}
	
	@Bean
	public Queue queueMessageA() {
		return new Queue("topic.a");
	}
	
	@Bean
	public Queue queueMessageB() {
		return new Queue("topic.b");
	}	
	
	@Bean
	Binding bindingExchangeMessageA(Queue queueMessageA, TopicExchange topicExchange) {
		return BindingBuilder.bind(queueMessageA).to(topicExchange).with(ROUTING_KEY_A);
	}
	
	@Bean
	Binding bindingExchangeMessageB(Queue queueMessageB, TopicExchange topicExchange) {
		return BindingBuilder.bind(queueMessageB).to(topicExchange).with(ROUTING_KEY_B);
	}	
	
}
