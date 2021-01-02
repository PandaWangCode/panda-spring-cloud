package nx.panda.main02_java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;

import org.junit.Test;

/**
 * lambda 本质就是一个函数式接口的隐式的实现(匿名实现)，对象
 * 函数式接口：：只包含了一个抽象方法的接口。@FunctionInterface
 */
public class OfferDemo {
	
    public static void main(String[] args) {
        //最开始java7的写法：匿名的内部类
    	//工资给的高的优先选择
        Comparator<Offer> comparator = new Comparator<Offer>() {

            @Override
            public int compare(Offer o1, Offer o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        };
        
        Offer o1 = new Offer();
        o1.setSalary(3000);
        Offer o2 = new Offer();
        o2.setSalary(5000);
        
        int compa =  comparator.compare(o1, o2);
        System.out.println("java7以前比较：工资高低："+compa);
        
        //lamdda
        Comparator<Offer> offerComparator = Comparator.comparingDouble(Offer::getSalary);
        int compa2 = offerComparator.compare(o1, o2);
        System.out.println("java8 lambda：工资高低：" + compa2); // -1,负数表示小于
    }

    /**
     * 字符串的比较器，String 长度达的大
     * lambda可以自动类型推断
     */

    @Test
    public void test01(){
    	// 定义一个字符串的比较器
        Comparator<String> comparator = (x,y) -> Integer.compare(x.length(), y.length());
        
        System.out.println("java8 lambda比较结果：  " + comparator.compare("hello", "nx") ); // -1,负数表示小于

    }
}
