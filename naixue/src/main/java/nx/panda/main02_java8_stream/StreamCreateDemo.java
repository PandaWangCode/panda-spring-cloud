package nx.panda.main02_java8_stream;

import org.junit.Test;
import nx.panda.main02_java8.Offer;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 创建流
 * 1、集合提供了相关的流操作
 * 2、Arrays.stream()
 * 3、Stream.of。。。
 * 使用流
 *
 * 关闭流
 */
public class StreamCreateDemo {

    static  Offer[] offerArray = {new Offer(101, "百度", 500, 9999.99),
            new Offer(102, "阿里巴巴", 700, 6666.66),
            new Offer(103, "腾讯", 800, 6666.66),
            new Offer(104, "字节跳动", 400, 7777.77),
            new Offer(105, "小米", 1000, 5555.55)};

    List<Offer> offerList = Arrays.asList(offerArray);

    @Test
    public void test01(){
        //1、通过Collection的集合提供stream()方法或者parallelStream()方法创建流
        Stream<Offer> stream01 = offerList.stream(); //顺序流
        Stream<Offer> stream011 = offerList.parallelStream(); //parallel 并行流
        
        //2、通过Array.stream()多去数组流
        Stream<Offer> stream02 = Arrays.stream(offerArray);
        //3、使用Stream.of也可以创建流
        Stream<String> stream03 = Stream.of("hello", "world", "nx", "samuel");
        //4、可以使用Stream.iterate创建无限流
        Stream<Integer> stream04 = Stream.iterate(0, (x) -> x + 2);
        Stream<Double> stream05 = Stream.generate(() -> Math.random());

        //关闭流
        Stream<Offer> stream = offerList.stream();
        stream.forEach(System.out::println);
        System.out.println("---------");
        stream.forEach(System.out::println);


    }

}
