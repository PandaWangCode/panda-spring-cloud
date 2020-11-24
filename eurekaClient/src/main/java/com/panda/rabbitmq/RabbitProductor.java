package com.panda.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProductor {
	
  @Autowired
  private AmqpTemplate amqpTemplate;
  
//  final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
//	  /**
//      *
//      * @param correlationData 唯一标识，有了这个唯一标识，我们就知道可以确认（失败）哪一条消息了
//      * @param ack  是否投递成功
//      * @param cause 失败原因
//      */
//     @Override
//     public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//         String messageId = correlationData.getId();
//         //返回成功，表示消息被正常投递
//         if (ack) {
//             System.out.printf("信息投递成功，messageId:{}",messageId);
//         } else {
//        	 System.out.printf("消费信息失败，messageId:{} 原因:{}",messageId,cause);
//         }
//     }
//  };
  
  public void sendMessage(String context) {
	  System.out.println("发送消息："+context);
	  amqpTemplate.convertAndSend(RabbitmqConfig.QUEUE_DIRECT_NAME, context);
  }
  
  public void sendMessageToFeignService(String context) {
	  System.out.println("发送消息："+context);
	  //设置投递回调
	  amqpTemplate.convertAndSend(RabbitmqConfig.QUEUE_DIRECT_NAME, context);
  }  
  
}
