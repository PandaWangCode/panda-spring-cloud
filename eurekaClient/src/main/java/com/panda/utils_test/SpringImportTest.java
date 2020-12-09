package com.panda.utils_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;


@Component
public class SpringImportTest {
    
	//存放四个类，这四个类都未用 component 注解。所以spring ioc容器里面是没有的
	public class TestBean1 {
	    @Override
	    public String toString() {
	        return super.toString()+"--我是TestBean1";
	    }
	}
	 
	public class TestBean2 {
	    @Override
	    public String toString() {
	        return super.toString()+"--我是TestBean2";
	    }
	}
	 
	public class TestBean3 {
	    @Override
	    public String toString() {
	        return super.toString()+"--我是TestBean3";
	    }
	}
	 
	public class TestBean4 {
	    @Override
	    public String toString() {
	        return super.toString()+"--我是TestBean4";
	    }
	}
	
	
	//通过@Configuration 和 Bean的方式，将TestBean2注入ioc容器
	@Configuration
	public class ImportBeanByConfig {
	    @Bean
	    public TestBean2 testBean2(){
	        return new TestBean2();
	    }
	}

}


