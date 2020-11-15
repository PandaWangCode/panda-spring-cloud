package com.panda.thread;

import java.util.Date;

public class MyThread2 extends Thread{
	
	private String name;
	
	public MyThread2(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		super.run();
		synchronized (this) {
			System.out.println("我是：" + name +"，MyThread2 执行了run方法。:"+ (new Date()).toString());
		}
	}

	@Override
	public void start() {
		super.start();
		System.out.println("我是："+ name +"，，MyThread2 执行了start方法。:"+ (new Date()).toString());
	}
	

}
