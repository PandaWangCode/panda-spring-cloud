package com.panda.serviceimpl.kafka;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserLogConsumer {
	
	@KafkaListener(topics = {"userLog"})
	public void conusmerReceive(ConsumerRecord<?,?> consumerRecord) {

        System.out.println("�������ߣ�"+consumerRecord.topic()+"-������"+consumerRecord.partition()+"-��Ϣ���ݣ�"+consumerRecord.value());

		/*
		 * Optional kfkMsg = Optional.ofNullable(consumerRecord.value()); if
		 * (kfkMsg.isPresent()) { Object msgObject = kfkMsg.get();
		 * System.out.print(msgObject); }
		 */
	}
	
}
