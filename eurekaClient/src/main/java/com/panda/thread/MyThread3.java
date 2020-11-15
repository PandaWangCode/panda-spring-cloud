package com.panda.thread;

import java.util.Date;

public class MyThread3 extends Thread{
	
	private String name;
	public static Object obj;
	
	public static int age;
	
	public MyThread3(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		synchronized (obj) {
			System.out.println("我是：" + name +"，拥有obj变量的锁，正在执行中，请稍等。"+ (new Date()).toString());
			try {
				System.out.println("我是：" + name +"，年龄："+ String.valueOf(age) + " " + (new Date()).toString());
				age ++;
				System.out.println("我是：" + name +"，年龄："+ String.valueOf(age) + " " + (new Date()).toString());
				
				System.out.println("我是：" + name +"，开始准备进入wait状态，释放了obj的锁，其他线程可以来用obj变量了");
				obj.wait();
				//obj.notifyAll();
				//MyThread3.sleep(10000);
				System.out.println("我是：" + name +"，我又重新就绪状态了，拿到了obj的锁.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("我是：" + name +"，锁外面的方法");
	}

}
