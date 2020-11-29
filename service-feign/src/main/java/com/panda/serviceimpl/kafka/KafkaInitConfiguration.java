package com.panda.serviceimpl.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaInitConfiguration {

	/**
	 * 创建topic,并设置分区数为8，分区副本数为2
	 * @return
	 */
	@Bean
	public NewTopic initialTopic() {
		return new NewTopic("userLog", 4, (short) 2);
	}
	
}
