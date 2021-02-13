package nx.panda.main02_java8;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Description: lamda表达式
 * Author: wangpan
 * Date: 2021-02-12 下午 5:43
 **/
public class Lamdatest {

    /**
      * @author Administrator
      * @create 2021-02-12
      * @desc lamda表达式作用，:: 的三种用法
    **/ 
    @Test
    public  void test1(){
        // :: 访问静态方法
        Function<String,String> function = Something::getTestString;
        String ss = function.apply("123");
        System.out.println(ss);

        // :: 访问构造方法
        Supplier<Something> constructor = Something::new;
        Something som= constructor.get();
        System.out.println(som);

        // :: 访问对象方法,必须是实列化的对象
        Something something = new Something();
        Predicate<String> isNull = something::startWith; //这里对象实列直接访问对象方法
        System.out.println(isNull);

    }


    static class Something  {

        Something(){
            System.out.println("构造方法执行");
        }

        //静态方法
        static String getTestString(String ss){
            return ss+"1，静态方法获取";
        }

        //对象方法
        boolean startWith(String ss){
            return null == ss ? true : false;
        }

    }

}
