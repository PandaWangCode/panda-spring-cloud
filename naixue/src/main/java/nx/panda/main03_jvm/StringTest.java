package nx.panda.main03_jvm;

/**
 * jvm 反编译说明jvm的命令,查看区别。
 * @author Administrator
 *
 */

public class StringTest {

	//javap 反编译说明：
    public static void m1(){
        String str = "";
        for (int i=0;i<10;i++){
            str = str+"nx,"; // javap反编译后:循环之间做了很多的new 操作，虽然做了优化用springbuilder,但是每次都会new，所以String循环拼接操作很慢
        }
        System.out.println(str);

    }

    public static void m2(){
        StringBuffer str = new StringBuffer();
        for (int i=0;i<10;i++){
            str.append("nx,"); // javap反编译后:循环之间没有new操作，一直做append操作
        }
        System.out.println(str);

    }

    public static String m3(){
        String str = "hello";
        try {
           return str; // javap反编译解析：这里直接areturn了 
        }finally {
          str = "nx";  // 虽然上面return后，这里继续赋值，最终是返回hello,并不是nx.
        }
    }

    public static void main(String[] args) {
    	System.out.println(m3()); 
    }

}
