package com.panda.hashmap;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue阻塞队列的用法
 * @author Administrator
 *
 */
public class ArrayBlockingQueueTest {
	
	//测试入口
	public static void main(String[] args) {
		System.out.println("测试开始");
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
//生产者线程
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

//消费者
class Customer implements Runnable{
	protected ArrayBlockingQueue queue =  null;
	
	public Customer(ArrayBlockingQueue queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			//第一次能快速拿到值
			System.out.println("take :" + queue.take());
			//第二次，因为上面设置的是一秒钟生产一次，如果试图的操作无法立即执行，
			//这里的调用将会发生阻塞，直到能够执行,所以这里在等2的放入，放入后立即执行了
			System.out.println("take :" + queue.take()); 
			//第三次
			System.out.println("take :" + queue.take());
			//第四次，一直取不到，这里线程就会一直阻塞，注意生产中可能会出问题
			//System.out.println("take :" + queue.take());
			//第四次，这次取不到，所以设置三秒钟的时间限制。拿不到就放弃，结束了。
			System.out.println("pool :" + queue.poll(3, TimeUnit.SECONDS));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
