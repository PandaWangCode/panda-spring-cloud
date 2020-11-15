package com.panda.hashmap;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue�������е��÷�
 * @author Administrator
 *
 */
public class ArrayBlockingQueueTest {
	
	//�������
	public static void main(String[] args) {
		System.out.println("���Կ�ʼ");
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(100);
        Producter producer = new Producter(queue);  
        Customer consumer = new Customer(queue);  
        new Thread(producer).start();  
        new Thread(consumer).start();  
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
//�������߳�
class Producter implements Runnable{
	protected 	ArrayBlockingQueue queue = null;
	public Producter(ArrayBlockingQueue arrayBlockingQueue) {
		queue = arrayBlockingQueue;
	}

	@Override
	public void run() {
		try {  
            queue.put("1");  
            System.out.println("put"+1);
            Thread.sleep(1000);  
            queue.put("2");
            System.out.println("put"+2);
            Thread.sleep(1000);  
            queue.put("3"); 
            System.out.println("put"+3);
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } 
	}
	
}

//������
class Customer implements Runnable{
	protected ArrayBlockingQueue queue =  null;
	
	public Customer(ArrayBlockingQueue queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			//��һ���ܿ����õ�ֵ
			System.out.println("take :" + queue.take());
			//�ڶ��Σ���Ϊ�������õ���һ��������һ�Σ������ͼ�Ĳ����޷�����ִ�У�
			//����ĵ��ý��ᷢ��������ֱ���ܹ�ִ��,���������ڵ�2�ķ��룬���������ִ����
			System.out.println("take :" + queue.take()); 
			//������
			System.out.println("take :" + queue.take());
			//���ĴΣ�һֱȡ�����������߳̾ͻ�һֱ������ע�������п��ܻ������
			//System.out.println("take :" + queue.take());
			//���ĴΣ����ȡ�������������������ӵ�ʱ�����ơ��ò����ͷ����������ˡ�
			System.out.println("pool :" + queue.poll(3, TimeUnit.SECONDS));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
