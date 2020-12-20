package nx.panda.main01_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ArrayListAndVector {

	  public static void main(String[] args) {
		  Integer[] array = {1, 2};
		  List<Integer> integerList = Arrays.asList(array);
		  Object[] objectArray = integerList.toArray();
		  System.out.println(objectArray.getClass() == Object[].class); //true;
		  
		  List<Integer> list = new ArrayList<Integer>();
		  System.out.println(list.toArray().getClass() == Object[].class); //true;
		  
		  //1 arraylist是非线程安全的
		  
		  //2 Vector是线程安全的,内部源码：内部方法实现了加锁的机制
		  Vector<Integer> vectors = new Vector<Integer>();
		  
		  //3 如何将ArrayList变成线程安全的？
		  Collections.synchronizedList(list);  //静态方法：synchronizedList这样将变成线程安全的。
	  }
	  
}
