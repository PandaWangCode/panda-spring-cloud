package com.panda.serviceimpl.kafka;

import java.util.Map;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class CustomizePartitioner implements Partitioner{

	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		
	}

	// partition�����ķ���ֵ�ͱ�ʾ����Ϣ���͵����ŷ���
	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
