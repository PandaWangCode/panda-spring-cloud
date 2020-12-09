package com.panda.utils_test;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.panda.utils_test.SpringImportTest.TestBean4;

public class ImportBeanByImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
   
	@Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestBean4.class);
        registry.registerBeanDefinition("TestBean4", rootBeanDefinition);
    }
}