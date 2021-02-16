package nx.panda.main02_java8;

import static org.hamcrest.CoreMatchers.nullValue;
import java.util.Optional;
import org.junit.Test;
import java.util.concurrent.ForkJoinPool;

/**
 * java8 推出的Optional的目的就是为了杜绝空指针异常，帮助开发者开发出更优雅的代码，
 * 使用Optional不正确时，将会违背设计者的初衷。

一、Optional的构造方式：
1、Optional.of(T)  

该方式的入参不能为null，否则会有NPE，在确定入参不为空时使用该方式。

2、Optional.ofNullable(T)

该方式的入参可以为null，当入参不确定为非null时使用。

3、Optional.empty()

这种方式是返回一个空Optional，等效Optional.ofNullable(null)

尽量避免使用的地方：
1、避免使用Optional.isPresent()来检查实例是否存在，因为这种方式和null != obj没有区别，这样用就没什么意义了。

2、避免使用Optional.get()方式来获取实例对象，因为使用前需要使用Optional.isPresent()来检查实例是否存在，否则会出现NPE问题。

3、避免使用Optional作为类或者实例的属性，而应该在返回值中用来包装返回实例对象。

4、避免使用Optional作为方法的参数，原因同3。

 * @author Administrator
 *
 */
public class MyOptionalDemo {
	
	/**
	 * 1、实例对象存在则返回，否则提供默认值或者通过方法来设置返回值，即使用orElse/orElseGet方式：
	 */
	@Test
	public void test1() {
		Offer offer = new Offer(5000);
		//1、Optional.of(T)  
		//该方式的入参不能为null，否则会有NPE，在确定入参不为空时使用该方式。
		Optional<Offer> offer2 = Optional.of(offer);
		Offer offer3 = offer2.orElse(new Offer());
		System.out.println(offer3.getEmpNumber());

	}

	@Test
	public void test2() {
		Offer offer = null;
		Optional<Offer> offer2 = Optional.ofNullable(offer).map(o->new Offer(5000)); //返回是null
		System.out.println(offer2.toString());

		//同样的语句，同样的操作，只是这个时候offer不是null
		Offer oOffer2 = new Offer(100);
		Optional<Offer> offer3 = Optional.ofNullable(oOffer2).map(o->new Offer(5000)); //返回是5000的结果
		System.out.println(offer3.toString());

		String s = extracted(new Offer(499));
		System.out.println("s = " + s);
		String s2 = extracted(null);
		System.out.println("s = " + s2);



		Offer e = extracted2(new Offer(499));
		System.out.println("e = " + e);
		Offer e2 = extracted2(null);
		System.out.println("e = " + e2);

	}

	private static String extracted(Offer oOffer2) {
		//接着测试：多层map会返回最后一个map的值
		return  Optional.ofNullable(oOffer2)
				.map(n-> String.valueOf(n.getEmpNumber()))
				.orElse("空值");
				//.orElseGet(()->"");
				//.orElseThrow(()->new IllegalArgumentException("Invalid getEmpNumber."));
	}

	private static Offer extracted2(Offer oOffer2) {
		return  Optional.ofNullable(oOffer2).orElse(new Offer());//空则new一个，不空就返回
	}


}
