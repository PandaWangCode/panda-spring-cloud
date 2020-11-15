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
			System.out.println("���ǣ�" + name +"��MyThread2 ִ����run������:"+ (new Date()).toString());
		}
	}

	@Override
	public void start() {
		super.start();
		System.out.println("���ǣ�"+ name +"����MyThread2 ִ����start������:"+ (new Date()).toString());
	}
	

}
