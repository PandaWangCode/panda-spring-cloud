package nx.panda.main02_java8;

import java.util.function.Consumer;

//java8 提供了4大函数式接口，Consumer是消费型，void类型,通过accept来接受参数
public class LambdaCore {
	
    public static void main(String[] args) {
        Consumer<Offer> consumer = offer -> System.out.println("编号"+offer.getId()+"同学，给你发来"+offer.getComName()+"的offer了");
        consumer.accept(new Offer(101, "panda", 100, 9999999));

        //脱糖
        System.out.println(consumer.getClass().getName());

    }
    
}
