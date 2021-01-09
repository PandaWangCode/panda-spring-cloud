package nx.panda.main03_jvm.classloader;

/**
 * 用了验证自定义加载器是否加载成功class用
 * @author Administrator
 *
 */
public class Dog {
	static {
		System.out.println("Dog.class 加载成功了!");
	}
}
