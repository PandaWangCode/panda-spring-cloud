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
	
	//�������
	public static void main(String[] args) {
		System.out.println("���Կ�ʼ");
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
	 * HashMap����ArrayList�߱�����ɾ�����ݻᱨjava.util.ConcurrentModificationException�쳣
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
	 * HashMap Ҫ�õ�����ɾ��Ԫ��
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
	 * ConcurrentHashMap ��ConcurrentHashMap�߱�����ɾ���������Ӳ�����������쳣(���Բ��õ�����ʽɾ��Ԫ��)��
	 * ��Ϊ���ڲ��Ѿ�����ά����������ʱ���ܻ�����µ�ֵ��
	 * �����Ƕ���߳�һ��ɾ�������Ԫ��Ҳû���⡣
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
	 * һ���̶߳�ConcurrentHashMap�������ݣ�����һ���߳��ڱ���ʱ���ܻ�á�
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

        
        //��ӡ���
        try {
			Thread.currentThread().sleep(3000);
		    System.out.println("�Ա�������Ķ��߳�ִ�к��MAP�ĸ�����ӡ����Ƿ�һ��--------");
	        for (Entry<Long, String> entry : conMap.entrySet()) {
	            System.out.println(entry.getKey() + " " + entry.getValue());
	        }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("�Աȷ�����Ȼ�Ƕ��̣߳�����map�����ǽ��һ��--------");
	}
	
	
	
}
