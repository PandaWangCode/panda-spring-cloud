package com.panda.thread;

import java.util.Map;

import org.junit.validator.PublicClassValidator;

/* volatile 原理和实现机制:
 * 1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，
 * 也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，
 * 在它前面的操作已经全部完成；

2）它会强制将对缓存的修改操作立即写入主存；

3）如果是写操作，它会导致其他CPU中对应的缓存行无效*/

public class ThreadVolatile2 {
	
	//1.状态标记量
	volatile static int x = 100;
	
	public static String  str = "abc";
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				str ="def";
				for (int i = 0; i < 100; i++) {
					x = x + 1;
				}
				
				System.out.println("1执行后的X值为：" + x);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					x = x + 1;
				}
				
				System.out.println("2执行后的X值为：" + x);
			}
		});
		
		//两个线程同时对 x 进行100次加1，发现打印结果不确定。
		t1.start();
		t2.start();
		
	}
	
}
