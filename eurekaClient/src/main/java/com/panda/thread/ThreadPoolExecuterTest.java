package com.panda.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecuterTest {
	
	public static void main(String[] args) {
		
		execThreadByLinkedBlockingQueue();
		
		//带优先级的线程池
		//execThreadByPriorityBlockingQueue();
	}

    //线程池：链表线程队列，链表队列的好处是采用了分离锁，队列的生产者和消费者，可以同时并行操作
	private static void execThreadByLinkedBlockingQueue() {
		//阻塞队列的 capacity 最好和 线程池ThreadPoolExecutor exec提交runable执行的次数相等，能装下所有的队列
		BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>(95);
		
		ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(
				3, 5, 1, TimeUnit.SECONDS, blockingQueue); /*threadFactory, handler);*/
		//测试一：报错：Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.panda.thread.ThreadPoolExecuterTest$MyExecRunClass@3b22cdd0 rejected from java.util.concurrent.ThreadPoolExecutor@1e81f4dc[Running, pool size = 5, active threads = 0, queued tasks = 0, completed tasks = 15]
		threadPoolExecutor.allowCoreThreadTimeOut(true);
		for (int i = 0; i < 100; i++) {
			threadPoolExecutor.execute(new MyExecRunClass(i));
        }
		
	}
	
	static class MyExecRunClass implements Runnable {
		
		private int nowThread;
		
		MyExecRunClass(int nowThread){
			this.nowThread = nowThread;
		}
		
		public void run() {
			System.out.println( nowThread +":"+Thread.currentThread().getName() + " LinkedBlockingQueue 执行业务逻辑!");
		}
	}
	
	
    //带优先级线程池
	private static void execThreadByPriorityBlockingQueue() {
		//PriorityBlockingQueue 
		BlockingQueue<Runnable> blockingQueue = new PriorityBlockingQueue<Runnable>(95);
		
		ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(
				3, 5, 1, TimeUnit.SECONDS, blockingQueue); /*threadFactory, handler);*/
		threadPoolExecutor.allowCoreThreadTimeOut(true);
		for (int i = 0; i < 50; i++) {
			final int priority = i;
			
			MyExecRunClass2 myExecRunClass2 = new MyExecRunClass2(i, i) {
				
				@Override
				public void doSomeThing() {
					String threadName = Thread.currentThread().getName();
					System.out.println("线程：" + threadName + ",正在执行优先级为：" + priority + "的任务");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
				}
				
			};
			
			threadPoolExecutor.execute(myExecRunClass2);
        }
	}	
	
	static abstract class MyExecRunClass2 implements Runnable,Comparable<MyExecRunClass2> {
		
		private int nowThread;
		
		private int order;  //定义一个排序规则，越小的越先执行 
		
		MyExecRunClass2(int nowThread, int order ){
			this.nowThread = nowThread;
			this.order = order;
		}
		
		public abstract void doSomeThing();
		
		public void run() {
			doSomeThing();
			System.out.println( nowThread +":"+Thread.currentThread().getName() + " PriorityBlockingQueue 执行业务逻辑!");
		}

		public int compareTo(MyExecRunClass2 other) {
			return this.order > other.order ? 0 : -1;
		}
	}
	

}
