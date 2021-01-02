package nx.panda.main02_java8;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * lambda:理解为一个匿名的函数，可以理解为一段可以传递的代码，(将代码像数据一样传递)。
 * jdk8为我们四大函数式接口供调用：
 * 1、消费型的：Consumer<T> void accept方法接受参数,
 * 2、创建型的：Supplier<T> T ,get() 返回值
 * 3、函数型：Function<T, R> 传入T类型，返回R类型
 * 4、判断型：Predicate<T,R>
 * @author panda
 */
public class Lambda {
	
	 /**
     * 类名::方法名
     */
    @Test
    public void test01(){
        Consumer<String> consumer = str->System.out.println(str);
        consumer.accept("hello nx");
        
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("hello panda");
        
        Consumer<Integer> consumer2 = num -> { 
        	System.out.println(num);
        	System.out.println(num);
        	System.out.println(num);
        };
        consumer2.accept(234);
        
    }

    /**
     * Supplier get()
     */
    @Test
    public void  test02(){
        Offer off = new Offer(101, "panda", 100, 9999999);
        Supplier<String> sup = ()->off.getComName();
        System.out.println(sup.get());

        Supplier<String> sup1  = off::getComName;
        System.out.println(sup1.get());
        
        
        Offer off2 = new Offer(102, "panda", 100, 4343);
        Supplier<Double> sup2 = () -> { 
        	System.out.println("计算工资组成：");
        	return (double) off2.getSalary() + 5000; 
        	};	//基本工资+5000底薪，返回
        System.out.println(sup2.get());
    }

    /**
     * 方法的参数正好是实际调用的方法的调用者
     * 类名：：实例方法
     */
    @Test
    public void  test03(){
        BiPredicate<String,String> bp = (x,y)->x.equals(y);
        System.out.println(bp.test("abc","bcd"));
        BiPredicate<String,String> bp1 = String::equals;
        System.out.println(bp1.test("abc","bcd"));

        System.out.println("-------------------------");
        //需求，给定offer，得到offer的字符串表现形式，
        Function<Offer,String> fun = (o)->o.toString();
        System.out.println(fun.apply(new Offer(101, "奈学", 100, 9999999)));

        Function<Offer,String> fun2 = Offer::toString;
        System.out.println(fun2.apply(new Offer(101, "奈学", 100, 9999999)));
        
        
        System.out.println("传入Offer类型，返回Inger类型：");
        Function<Offer, Integer> fun3 = (o)->o.getId();
        System.out.println("fun3的id是"+fun3.apply(new Offer(1005, "panda", 100, 9999999)));
        
    }

    @Test
    public void test04(){
        Supplier<Offer> supplier = ()->new Offer();
        Supplier<Offer> supplier1 = Offer::new;
        System.out.println(supplier1.get());

        Function<Integer,Offer> fun1 = (id)->new Offer(id);
        Function<Integer,Offer> fun2 = Offer::new;

        Function<Integer,Offer[]> fun3 = Offer[]::new;
    }

}
