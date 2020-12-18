package com.panda.controller.utlis_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panda.utils_test.ConditionalClassTest;
import com.panda.utils_test.SpringImportTest.TestBean1;
import com.panda.utils_test.SpringImportTest.TestBean2;
import com.panda.utils_test.SpringImportTest.TestBean3;
import com.panda.utils_test.SpringImportTest.TestBean4;

/*总结一下@Import注解的用法:
	1.导入一个或多个Bean
	2.导入@Configuration类
	3.导入ImportSelector的实现类
	4.导入ImportBeanDefinitionRegistrar的实现类
    *
    这些用法或许只有一个目的，就是导入Bean。那为什么要这么麻烦，手动导入Bean呢，
    @ComponentScan不是可以自动扫描包注册Bean嘛？
    其实这里的原因有两点：
	@ComponentScan一般只会扫到自己项目中的Bean，第三方jar包中的@Bean扫不到
	@Import注解可以结合@Conditional注解使用，即条件导入，
	@Conditional在spring源码中也是大量用到，这个我后面会专题介绍*/
@RestController
public class CommonController {
	
    @Autowired(required = false)
    private TestBean1 testBean1;
    @Autowired(required = false)
    private TestBean2 testBean2;
    @Autowired(required = false)
    private TestBean3 testBean3;
    @Autowired(required = false)
    private TestBean4 testBean4;
 
    @RequestMapping("/import")
    public String printImportBeanInfo(){
    	Assert.notNull(testBean4, "testbean4为空!"); //Assert干掉if else
    	
        System.out.println(testBean1);
        System.out.println(testBean2);
        System.out.println(testBean3);
        System.out.println(testBean4);
        return "testBean1:"+ testBean1.toString() +"\\n ,testBean2:"+ testBean2.toString() +"\\n ,testBean3:"+ testBean3.toString() +"\\n ,testBean4:"+ testBean4.toString();
    }
    
    
    @Autowired(required = false)
    private ConditionalClassTest conditionalClassTest;
    
    @RequestMapping("/conditional")
    public String printConditionalInfo(){
    	if (null == conditionalClassTest) {
    		System.out.println(conditionalClassTest + "实例未构建成功");
    		return  "conditionalClassTest实例未构建成功";
    	} else {
    		System.out.println(conditionalClassTest+"conditionalClassTest实例构建成功,ConditionalClass1实例也构建成功");
    		return  conditionalClassTest +"conditionalClassTest实例构建成功,ConditionalClass1实例也构建成功";
    	}
    }    
    
}
