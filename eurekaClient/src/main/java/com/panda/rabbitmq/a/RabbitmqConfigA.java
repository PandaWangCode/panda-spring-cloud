package com.panda.rabbitmq.a;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfigA {
	
	public static final String  EXCHANGE_TOPIC = "com.panda.exchange.topic123";
	
	public static final String  ROUTING_KEY_A = "rountkey.topic.a";
	public static final String  ROUTING_KEY_B = "rountkey.topic.#";
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(EXCHANGE_TOPIC);
	}
	
	@Bean
	public Queue queueMessageA() {
		return new Queue("queue.topic.a");
	}
	
	@Bean
	public Queue queueMessageB() {
		return new Queue("queue.topic.b");
	}	
	
	@Bean
	Binding bindingExchangeMessageA(@Qualifier("queueMessageA")Queue queueMessageA, TopicExchange topicExchange) {
		return BindingBuilder.bind(queueMessageA).to(topicExchange).with(ROUTING_KEY_A);
	}
	
	@Bean
	Binding bindingExchangeMessageB(@Qualifier("queueMessageB")Queue queueMessageB, TopicExchange topicExchange) {
		return BindingBuilder.bind(queueMessageB).to(topicExchange).with(ROUTING_KEY_B);
	}	
	
}
