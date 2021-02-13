package nx.panda.main02_java8;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Description: lamda表达式,::的用法
 * Author: wangpan
 * Date: 2021-02-12 下午 5:43
 **/
public class Lamdatest2_new {

    /**
      * @author Administrator
      * @create 2021-02-12
      * @desc
    **/
    @Test
    public  void test1(){
        String yearMonthWeek = "month";

        // 以前的判断写法
        if ("year" == yearMonthWeek){
            System.out.println("yearMonthWeek = " + yearMonthWeek);
        }else if ("month" == yearMonthWeek){
            System.out.println("yearMonthWeek = " + yearMonthWeek);
        }else if ("week" == yearMonthWeek ) {
            System.out.println("yearMonthWeek = " + yearMonthWeek);
        }

        System.out.println("加入lambda 表达式后===========1");
        //加入lamda表达式以后
        sysTemotYearMonthWeek("year", n-> "year" == yearMonthWeek);
        sysTemotYearMonthWeek("month", n-> "month" == yearMonthWeek);
        sysTemotYearMonthWeek("week", n-> "week" == yearMonthWeek);

        System.out.println("加入lambda 表达式后===========2");
        //predicate 条件可以合并通过 and / or / xor
        sysTemotYearMonthWeek("year", n->"year" == yearMonthWeek );

    }

    public void sysTemotYearMonthWeek(String ss,Predicate<String>  predicate){
        if (predicate.test(ss)) {
            System.out.println("yearMonthWeek = " + ss);
        }
    }

}
