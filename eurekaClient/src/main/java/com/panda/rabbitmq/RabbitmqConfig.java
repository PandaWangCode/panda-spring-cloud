package com.panda.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
	
	public static final String QUEUE_DIRECT_NAME = "com.panda.direct";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_DIRECT_NAME);
	}
}
