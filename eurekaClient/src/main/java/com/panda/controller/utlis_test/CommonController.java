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

/*�ܽ�һ��@Importע����÷�:
	1.����һ������Bean
	2.����@Configuration��
	3.����ImportSelector��ʵ����
	4.����ImportBeanDefinitionRegistrar��ʵ����
    *
    ��Щ�÷�����ֻ��һ��Ŀ�ģ����ǵ���Bean����ΪʲôҪ��ô�鷳���ֶ�����Bean�أ�
    @ComponentScan���ǿ����Զ�ɨ���ע��Bean�
    ��ʵ�����ԭ�������㣺
	@ComponentScanһ��ֻ��ɨ���Լ���Ŀ�е�Bean��������jar���е�@Beanɨ����
	@Importע����Խ��@Conditionalע��ʹ�ã����������룬
	@Conditional��springԴ����Ҳ�Ǵ����õ�������Һ����ר�����*/
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
    	Assert.notNull(testBean4, "testbean4Ϊ��!"); //Assert�ɵ�if else
    	
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
    		System.out.println(conditionalClassTest + "ʵ��δ�����ɹ�");
    		return  "conditionalClassTestʵ��δ�����ɹ�";
    	} else {
    		System.out.println(conditionalClassTest+"conditionalClassTestʵ�������ɹ�,ConditionalClass1ʵ��Ҳ�����ɹ�");
    		return  conditionalClassTest +"conditionalClassTestʵ�������ɹ�,ConditionalClass1ʵ��Ҳ�����ɹ�";
    	}
    }    
    
}
