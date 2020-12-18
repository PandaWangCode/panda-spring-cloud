package com.panda.utils_test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//创建ImportSelector 接口的实现,在另外一个测试里面，通过import导入，就可以注入到ioc容器
public class ImportBeanByImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.panda.utils_test.SpringImportTest.TestBean3"};
	}
}