package nx.panda.main03_jvm.classloader;


/**
 * 双亲委派机制，加载class文件
 * @author Administrator
 *
 */
public class Main {
	
	//执行报错:不是springboot下运行,spring
    public static void main(String[] args) throws Exception {
        //类加载器加载的目录
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(System.getProperty("java.ext.dirs"));
//        System.out.println(System.getProperty("java.class.path"));
        
        //自定义加载器
        SelfClassLoader classLooader = new SelfClassLoader("d:\\ceshi\\", "samuel");
        Class<?> dogClazz = classLooader.loadClass("nx.panda.main03_jvm.classloader.Dog");
        // 拿到该对象，就能利用反射new一个对象，做测试看对象,是否能
        Object dogObj = dogClazz.newInstance();
        System.out.println(dogObj.getClass().getClassLoader());
        System.out.println(dogObj.getClass().getClassLoader().getParent());
        System.out.println(dogObj.getClass().getClassLoader().getParent().getParent());
        //System.out.println(dogObj.getClass().getClassLoader().getParent().getParent().getParent());
    }
}
