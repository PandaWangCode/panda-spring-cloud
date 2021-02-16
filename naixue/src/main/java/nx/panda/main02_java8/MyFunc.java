package nx.panda.main02_java8;

@FunctionalInterface
public interface MyFunc<T> {

    //抽象方法
    public T getValue(T t);

    //抽象方法
    default void setValue(T t){
        System.out.println("默认实现");
    }
}