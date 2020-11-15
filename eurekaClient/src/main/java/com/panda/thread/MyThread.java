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
				System.out.println("���ǣ�" + name +",�����ˡ�:"+ (new Date()).toString());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("���ǣ�" + name +"��ִ����run������:"+ (new Date()).toString());
	}

	@Override
	public void start() {
		super.start();
		System.out.println("���ǣ�"+ name +"��ִ����start������:"+ (new Date()).toString());
	}
	

}
