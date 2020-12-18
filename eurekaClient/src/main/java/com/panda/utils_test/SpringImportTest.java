package com.panda.utils_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;


@Component
public class SpringImportTest {
    
	//����ĸ��࣬���ĸ��඼δ�� component ע�⡣����spring ioc����������û�е�
	public class TestBean1 {
	    @Override
	    public String toString() {
	        return super.toString()+"--����TestBean1";
	    }
	}
	 
	public class TestBean2 {
	    @Override
	    public String toString() {
	        return super.toString()+"--����TestBean2";
	    }
	}
	 
	public class TestBean3 {
	    @Override
	    public String toString() {
	        return super.toString()+"--����TestBean3";
	    }
	}
	 
	public class TestBean4 {
	    @Override
	    public String toString() {
	        return super.toString()+"--����TestBean4";
	    }
	}
	
	
	//ͨ��@Configuration �� Bean�ķ�ʽ����TestBean2ע��ioc����
	@Configuration
	public class ImportBeanByConfig {
	    @Bean
	    public TestBean2 testBean2(){
	        return new TestBean2();
	    }
	}

}


