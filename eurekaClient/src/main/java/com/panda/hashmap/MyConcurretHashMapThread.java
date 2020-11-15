package com.panda.hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import com.panda.EureakClientApplication;

public class MyConcurretHashMapThread implements Runnable{
	
	//测试入口
	public static void main(String[] args) {
		System.out.println("测试开始");
		testRemove();
		testIteratorRemove();
		testConcurrentHashMapRemove();
		testConcurrentHashMapPutAndUpdate();
	}
	
	ConcurrentHashMap<String, Object> itToStrs = new ConcurrentHashMap<>();
	Hashtable<String, Object> hashtable = new Hashtable<>();
	
	
	MyConcurretHashMapThread(){
	}
	
	
	@Override
	public void run() {
		
	}
	
	/**
	 * HashMap或者ArrayList边遍历边删除数据会报java.util.ConcurrentModificationException异常
	 */
	public static void testRemove() {
		System.out.println("=================1==============");
		try {
			Map<Long, String> mReqPacket = new HashMap<Long, String>();
	        for (long i = 0; i < 15; i++) {
	            mReqPacket.put(i, i + "");
	        }

	        for (Entry<Long, String> entry : mReqPacket.entrySet()) {
	            long key = entry.getKey();
	            String value = entry.getValue();
	            if (key < 10) {
	                mReqPacket.remove(key);
	            }
	        }

	        for (Entry<Long, String> entry : mReqPacket.entrySet()) {
	            System.out.println(entry.getKey() + " " + entry.getValue());
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * HashMap 要用迭代器删除元素
	 */
	public static void testIteratorRemove() {
		System.out.println("=================2==============");
		Map<Long, String> mReqPacket = new HashMap<Long, String>();
	    for (long i = 0; i < 15; i++) {
	        mReqPacket.put(i, i + "");
	    }
	
	    for (Iterator<Entry<Long, String>> iterator = mReqPacket.entrySet().iterator(); iterator.hasNext();) {
	        Entry<Long, String> entry = iterator.next();
	        long key = entry.getKey();
	        if (key < 10) {
	            iterator.remove();
	        }
	    }
	
	    for (Entry<Long, String> entry : mReqPacket.entrySet()) {
	        System.out.println(entry.getKey() + " " + entry.getValue());
	    }
	}
	
	/**
	 * ConcurrentHashMap 对ConcurrentHashMap边遍历边删除或者增加操作不会产生异常(可以不用迭代方式删除元素)，
	 * 因为其内部已经做了维护，遍历的时候都能获得最新的值。
	 * 即便是多个线程一起删除、添加元素也没问题。
	 */
	public static void testConcurrentHashMapRemove() {
		System.out.println("=================3==============");
		Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
        for (long i = 0; i < 15; i++) {
            conMap.put(i, i + "");
        }

        for (Entry<Long, String> entry : conMap.entrySet()) {
            long key = entry.getKey();
            if (key < 10) {
                conMap.remove(key);
            }
        }

        for (Entry<Long, String> entry : conMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
	}
	
	
	/**
	 * 一个线程对ConcurrentHashMap增加数据，另外一个线程在遍历时就能获得。
	 */
	static Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
	public static void testConcurrentHashMapPutAndUpdate() {
		System.out.println("=================4==============");
		for (long i = 0; i < 5; i++) {
            conMap.put(i, i + "");
        }
		
		Thread thread = new Thread(new Runnable() {
	        public void run() {
	            conMap.put(100l, "100");
	            System.out.println("ADD:" + 100);
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
		
		Thread thread2 = new Thread(new Runnable() {
	        public void run() {
	            for (Iterator<Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
	                Entry<Long, String> entry = iterator.next();
	                System.out.println(entry.getKey() + " - " + entry.getValue());
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    });
		
		thread.start();
        thread2.start();

        
        //打印结果
        try {
			Thread.currentThread().sleep(3000);
		    System.out.println("对比与上面的多线程执行后的MAP的个数打印结果是否一样--------");
	        for (Entry<Long, String> entry : conMap.entrySet()) {
	            System.out.println(entry.getKey() + " " + entry.getValue());
	        }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("对比发现虽然是多线程，但是map长度是结果一样--------");
	}
	
	
	
}
