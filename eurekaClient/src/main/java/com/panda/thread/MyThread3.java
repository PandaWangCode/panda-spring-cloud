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
			System.out.println("���ǣ�" + name +"��ӵ��obj��������������ִ���У����Եȡ�"+ (new Date()).toString());
			try {
				System.out.println("���ǣ�" + name +"�����䣺"+ String.valueOf(age) + " " + (new Date()).toString());
				age ++;
				System.out.println("���ǣ�" + name +"�����䣺"+ String.valueOf(age) + " " + (new Date()).toString());
				
				System.out.println("���ǣ�" + name +"����ʼ׼������wait״̬���ͷ���obj�����������߳̿�������obj������");
				obj.wait();
				//obj.notifyAll();
				//MyThread3.sleep(10000);
				System.out.println("���ǣ�" + name +"���������¾���״̬�ˣ��õ���obj����.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("���ǣ�" + name +"��������ķ���");
	}

}
