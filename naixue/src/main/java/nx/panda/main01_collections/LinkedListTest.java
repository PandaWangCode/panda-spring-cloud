package nx.panda.main01_collections;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListTest {
	
	  public static void main(String[] args) {
		  Integer[] array = {1, 2};
		  
		  // 双向链表
		  LinkedList<Integer> lList = new LinkedList<Integer>(); 
		  lList.add(123);
		  lList.add(34);
		  lList.add(567);
		  System.out.println(lList);
		  
		  //排序
		  Collections.sort(lList);
		  System.out.println(lList);
		  
		  Collections.synchronizedList(lList);  //静态方法：synchronizedList这样处理后将变成线程安全的。
		  
	  }
	  
}
