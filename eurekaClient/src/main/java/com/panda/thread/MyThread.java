package com.panda.thread;

import java.util.Date;

public class MyThread extends Thread{
	
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		super.run();
		try {
			synchronized (this) {
				MyThread.sleep(10000);
				System.out.println("我是：" + name +",醒来了。:"+ (new Date()).toString());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("我是：" + name +"，执行了run方法。:"+ (new Date()).toString());
	}

	@Override
	public void start() {
		super.start();
		System.out.println("我是："+ name +"，执行了start方法。:"+ (new Date()).toString());
	}
	

}
