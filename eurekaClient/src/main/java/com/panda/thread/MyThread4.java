package com.panda.thread;


public class MyThread4 extends Thread{
	
	private String name;
	
	public MyThread4(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("���ǣ�" + name +"������ִ��run()");
	}

}
