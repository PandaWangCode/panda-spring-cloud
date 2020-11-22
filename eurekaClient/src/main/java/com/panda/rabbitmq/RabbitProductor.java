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
//      * @param correlationData Ψһ��ʶ���������Ψһ��ʶ�����Ǿ�֪������ȷ�ϣ�ʧ�ܣ���һ����Ϣ��
//      * @param ack  �Ƿ�Ͷ�ݳɹ�
//      * @param cause ʧ��ԭ��
//      */
//     @Override
//     public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//         String messageId = correlationData.getId();
//         //���سɹ�����ʾ��Ϣ������Ͷ��
//         if (ack) {
//             System.out.printf("��ϢͶ�ݳɹ���messageId:{}",messageId);
//         } else {
//        	 System.out.printf("������Ϣʧ�ܣ�messageId:{} ԭ��:{}",messageId,cause);
//         }
//     }
//  };
  
  public void sendMessage(String context) {
	  System.out.println("������Ϣ��"+context);
	  amqpTemplate.convertAndSend(RabbitmqConfig.QUEUE_DIRECT_NAME, context);
  }
  
  public void sendMessageToFeignService(String context) {
	  System.out.println("������Ϣ��"+context);
	  //����Ͷ�ݻص�
	  amqpTemplate.convertAndSend(RabbitmqConfig.QUEUE_DIRECT_NAME, context);
  }  
  
}
