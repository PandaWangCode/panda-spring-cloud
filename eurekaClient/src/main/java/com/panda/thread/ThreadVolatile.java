package com.panda.thread;

import org.junit.validator.PublicClassValidator;

/* volatile 原理和实现机制:
 * 1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，
 * 也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，
 * 在它前面的操作已经全部完成；

2）它会强制将对缓存的修改操作立即写入主存；

3）如果是写操作，它会导致其他CPU中对应的缓存行无效*/

public class ThreadVolatile {
	
	//1.状态标记量
	static volatile boolean flag = false;
	
	public static void main(String[] args) {
		 
		 
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				int count = 0;
				while(!flag){
					count++;
					System.out.println(count+":"+Thread.currentThread().getName() + "打印");
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				setFlag();
				System.out.println(":"+Thread.currentThread().getName() + "更改了标志，请停止打印。");
			}
		});
		
		t1.start();
		t2.start();
	}
	
	public static void setFlag() {
	    flag = true;
	}
	
}
