package com.nx.vip.nefeatures.other;

import java.util.Optional;

import com.nx.vip.nefeatures.lambda.Offer;
import org.junit.Test;

/*
 * Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class OptionalDemo {
	

	@Test
	public void test1(){
		Optional<Offer> op1 = Optional.of(new Offer());
		System.out.println(op1.get());
		System.out.println("---------------------------------");

		Optional<Offer> op2 = Optional.ofNullable(null);
		System.out.println(op2.get());
		System.out.println("---------------------------------");

		Optional<Offer> op3 = Optional.empty();
		System.out.println(op3.get());
		System.out.println("---------------------------------");

		Optional<Offer> op4 = Optional.ofNullable(new Offer());
		if(op4.isPresent()){
			System.out.println(op4.get());
		}
		Offer offer = op4.orElse(new Offer(300));
		System.out.println(offer);

		Offer emp2 = op4.orElseGet(() -> new Offer());
		System.out.println(emp2);

		System.out.println("---------------------------------");
		Optional<Offer> op5 = Optional.of(new Offer(101, "百度", 666, 9999.99));

		Optional<String> op6 = op5.map(Offer::getComName);
		System.out.println(op6.get());

		Optional<String> op7 = op5.flatMap((off) -> Optional.of(off.getComName()));
		System.out.println(op7.get());

	}

}
