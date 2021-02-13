package nx.panda.main02_java8_stream;

import nx.panda.main02_java8.Offer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Description: Map和reduce操作
 * Author: wangpan
 * Date: 2021-02-13 下午 7:54
 **/
public class StreamMapAndReduce {

    /**
      * @author Administrator
      * @create 2021-02-13
      * @desc stream map 的用法
    **/
    @Test
    public void test01(){
        List<Integer> costBeforeTax = Arrays.asList(100,500,600);

        // 不使用lambda表达式为每个订单加上12%的税
        for (Integer cost : costBeforeTax) {
            double price = cost + 0.10*cost;
            System.out.println(price);
        }

        System.out.println("StreamMapAndReduce.test01===使用lambda表达式后");
        //使用lambda表达式
        costBeforeTax.stream().map(cost->cost + 0.10 * cost).forEach(System.out::println);

        System.out.println("StreamMapAndReduce.test01===使用lambda表达式，将每个薪资调整增加一万");
        // 将list中每个对象的参数 薪资加10000
        Arrays.stream(StreamCreateDemo.offerArray).map(offer -> offer.getSalary() + 10000).forEach(System.out::println);

        //reduce操作
        Double sumAll =  costBeforeTax.stream().map(cost->cost + 0.10 * cost).reduce((sum, cost)->sum+cost).get();
        System.out.println("sumAll = " + sumAll);
    }

}
