package nx.panda.main02_java8;

import static org.hamcrest.CoreMatchers.nullValue;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * java8 推出的Optional的目的就是为了杜绝空指针异常，帮助开发者开发出更优雅的代码，
 * 使用Optional不正确时，将会违背设计者的初衷。
 * @author Administrator
 *
 */
public class MyOptionalDemo2 {

	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
		//调用empty API， 创建一个空的Optional对象
		//Ps: isPresent API 是用来检查Optional对象中是否有值。只有当我们创建了一个含有非空值的Optional时才返回true。
		Optional<String> empty = Optional.empty();
		empty.isPresent();
	}

	@Test
	public void givenNonNull_whenCreatesOptional_thenCorrect() {
		//传递给of()的值不可以为空，否则会抛出空指针异常
		String name = "baeldung";
		Optional<String> opt = Optional.of(name);

		//有时我们需要传递一些空值，那我们可以使用下面这个API:ofNullable
		String name2 = "";
		Optional<String> opt2 = Optional.ofNullable(name2);

		//使用ofNullable API，则当传递进去一个空值时，不会抛出异常，而只是返回一个空的Optional对象，如同我们用Optional.empty API:
		String name3 = null;
		Optional<String> opt3 = Optional.ofNullable(name3);
		System.out.println("opt3.toString() = " + opt3.toString());

	}

	/**四 适当情况下使用isPresent API  ======================================================**/
	@Test
	public void givenOptional_whenIfPresentWorks_thenCorrect() {
		//String name = "baeldung";
		String name = null;
		//传统上，我们一般这样写来检查空值:
		if(name != null){
			System.out.println(name.length());
		}

		//问题在于，有时候我们会忘记了对空值进行检查，这时就可以使用这个API：
		Optional<String> opt = Optional.ofNullable(name);
		opt.ifPresent(n -> System.out.println(n.length()));

	}

	/**五 orEse && orElseGet =============================================================**/
	@Test
	public void whenOrElseWorks_thenCorrect() {
		//String nullName = null;
		String nullName = "123";
		//原来的写法
		if (null != nullName){
			System.out.println("name = " + nullName);
		} else {
			System.out.println("name = " + "john");
		}

		// 等价于==============
		//5.1   orElse
		//这个API被用来检索Optional对象中的值，它被传入一个“默认参数‘。
		// 如果对象中存在一个值，则返回它，否则返回传入的“默认参数”，如下所示：

		String name = Optional.ofNullable(nullName).orElse("john");
		System.out.println("name = " + name);

		//可以这样理解：
		// ofNullable，即是null != nullName的判断条件，并且返回当前对象，
		// orElse  相当于==null的条件判断
	}

	/**5.2 orElseGet
	 *  与orElsel类似，但是这个函数不接收一个“默认参数”，而是一个函数接口
	 *  **/
	@Test
	public void whenOrElseGetWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
		System.out.println("name = " + name);
	}

	//5.3 orElseGet 和 orElse两者区别
	// 重点==============当包装的对象都是空值，他们返回值是一样的。
	// 重点==============当包装的对象不是空，他们返回值是不一样的。

	// 要想理解这二者，首先让我们创建一个无参且返回定值的方法:
	public String getMyDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}
	//接下来，进行两个测试看看它们有什么区别:
	@Test
	public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
		String text = null;

		extrtSysouttext(text);
		//在这里示例中，我们的Optional对象中包含的都是一个空值，让我们看看程序执行结果:是一样的
		//两个Optional对象中都不存在value，因此执行结果相同。
		//那么当Optional对象中值存在时又是怎样呢？
	}

	private void extrtSysouttext(String text) {
		System.out.println("Using orElseGet:");
		String defaultText =Optional.ofNullable(text).orElseGet(this::getMyDefault);
		System.out.println("defaultText = " + defaultText);

		System.out.println("=======================================");
		System.out.println("Using orElse:");
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println("defaultText = " + defaultText);
	}
	//那么当Optional对象中值存在时又是怎样呢？
	@Test
	public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
		String text = "Text present";
		extrtSysouttext(text);
		//可以看到，当使用orElseGet去检索值时，getMyDefault并不执行，因为Optional中含有值，而使用orElse时则照常执行。
		// 所以可以看到，当值存在时，orElse相比于orElseGet，多创建了一个对象，可能从这个实例中你感受不到影响有多大，
		// 但考虑当getDefalut不仅仅是个简单函数，而是一个web service之类的，则多创建一个代价是比较大的。

	}


    /** 六   orElseThrow
	 * orElseThrow 当遇到一个不存在的值的时候，并不返回一个默认值，而是抛出异常
	 * **/
	@Test(expected = IllegalArgumentException.class)
	public void whenOrElseThrowWorks_thenCorrect() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseThrow(
				IllegalArgumentException::new);
	}



	//八   filter() ========================================================
	// 使用filter()来接受/拒绝一个一个值
	@Test()
	public void testFilter() {
		Modem modem = new Modem(50.00);
		System.out.println("modem is range = " + priceIsInRange1(modem));
		System.out.println("modem is range = " + priceIsInRange2(modem));
		Modem modem2 = new Modem(12.00);
		System.out.println("modem is range = " + priceIsInRange1(modem2));
		System.out.println("modem is range = " + priceIsInRange2(modem2));
		Modem modem3 = null;
		System.out.println("modem is range = " + priceIsInRange1(modem3));
		System.out.println("modem is range = " + priceIsInRange2(modem3));
		//测试发现两段代码输出结果完全一致
	}

	public class Modem {
		private Double price;

		public Modem(Double price) {
			this.price = price;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

	}
	//检查每一类调制解调器是否在我们可以承受的价格范围内，以前的写法:
	public boolean priceIsInRange1(Modem modem) {
		boolean isInRange = false;

		if (modem != null && modem.getPrice() != null
				&& (modem.getPrice() >= 10
				&& modem.getPrice() <= 15)) {

			isInRange = true;
		}
		return isInRange;
	}

	//Optional更改后的写法
	public boolean priceIsInRange2(Modem modem){
		return Optional.ofNullable(modem).map(m->m.getPrice())
				.filter(p->p>=10)
				.filter(p->p<=15).isPresent();
	}


	//九   map()
	//在之前的例子中，我们使用filter()来接受/拒绝一个一个值，而使用map()我们可以将一个值转换为另一个值。


	//十 flatMap() 有时我们可以使用flatmap()替换map()，二者不同之处在于，
	// map()只有当值不被包裹时才进行转换，而flatmap()接受一个被包裹着的值并且在转换之前对其解包
	// flatMap 能解多层包
	public class Person {
		private String name;
		private int age;
		private String password;

		public Optional<String> getName() {
			return Optional.ofNullable(name);
		}

		public Optional<Integer> getAge() {
			return Optional.ofNullable(age);
		}

		public Optional<String> getPassword() {
			return Optional.ofNullable(password);
		}

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	@Test
	public void givenOptional_whenFlatMapWorks_thenCorrect2() {
		Person person = new Person("john", 26);
		Optional<Person> personOptional = Optional.of(person);

		Optional<Optional<String>> nameOptionalWrapper
				= personOptional.map(Person::getName);
		Optional<String> nameOptional
				= nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
		String name1 = nameOptional.orElse("");
		System.out.println("name = " + name1);

		//需要注意，方法getName返回的是一个Optional对象，而不是像trim那样。这样就生成了一个嵌套的Optional对象。
		//
		//因此使用map，我们还需要再解包一次，而使用flatMap()就不需要了。
		String name = personOptional
				.flatMap(Person::getName)
				.orElse("");
		System.out.println("name = " + name);
	}

}
