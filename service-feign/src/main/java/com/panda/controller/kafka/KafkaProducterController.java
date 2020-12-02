package com.panda.controller.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducterController {
	    
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
    // 发送消息
    @GetMapping("/kafka/normal/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("userLog", normalMessage);
    }
    
//    带回调的生产者
//    kafkaTemplate提供了一个回调方法addCallback，我们可以在回调方法中监控消息是否发送成功 或 失败时做补偿处理，有两种写法
    @GetMapping("/kafka/callbackOne/{message}")
    public void sendMessage2(@PathVariable("message") String normaString) {
    	kafkaTemplate.send("userLog", normaString).addCallback(
        success -> {  //可以接受的参数
        	// 消息发送到的topic
    		String topic = success.getRecordMetadata().topic();
    		// 消息发送到的分区
    		int partition = success.getRecordMetadata().partition();
    		// 消息在分区内的offset
    		long offset = success.getRecordMetadata().offset();
    		System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
    		//su
    	}, failues -> {  //可以接受的参数
    		System.out.println("发送消息失败:" + failues.getMessage());
    	});
    	
    }
    
    
    @GetMapping("/kafka/transaction")
    public void sendMessage3() {
    	// 声明事务：后面报错消息不会发出去
    	kafkaTemplate.executeInTransaction(operation -> {
    		operation.send("userLog", "事物测试");
    		throw new RuntimeException("fail");
    	});
    	
		/*
		 * // 不声明事务：后面报错但前面消息已经发送成功了
		 * kafkaTemplate.send("userLog","test executeInTransaction"); throw new
		 * RuntimeException("fail");
		 */
    }
}
