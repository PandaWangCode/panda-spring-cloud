package nx.panda.main02_java8_stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Description: Map和reduce操作
 * Author: wangpan
 * Date: 2021-02-13 下午 7:54
 **/
public class StreamFilterAndCollectors {

    /**
      * @author Administrator
      * @create 2021-02-13
      * @desc stream map 的用法
    **/
    @Test
    public void test01(){
        List<Integer> costBeforeTax = Arrays.asList(100,500,600);
        //使用lambda表达式
        List<Integer> costList2 = costBeforeTax.stream().filter(n->n>=200).collect(Collectors.toList());
        System.out.println("StreamMapAndReduce.test01===使用lambda表达式后");
        //使用stream的filter，原来的list集合大小并没有改变，仍然是100,500,600
        //说明获取的是一个新的list,但使用filter()方法则是获得一个新的列表，且其每个元素符合过滤原则。
        System.out.println("costBeforeTax = " + costBeforeTax);
        System.out.println("costList2 = " + costList2);
        //新的list
    }

    /**
      * @author Administrator
      * @create 2021-02-13
      * @desc 将公司的名字用逗号连接组合起来 Collectors.toList() Collectors.joining
    **/
    @Test
    public void test02(){
       List<String> list1 =  Arrays.stream(StreamCreateDemo.offerArray).map(offer -> offer.getComName())
               .collect(Collectors.toList());
       System.out.println("list1 = " + list1);

        //
        String list2 =  Arrays.stream(StreamCreateDemo.offerArray).map(offer -> offer.getComName())
                .collect(Collectors.joining(","));
        System.out.println("list1 = " + list2);


    }


}
