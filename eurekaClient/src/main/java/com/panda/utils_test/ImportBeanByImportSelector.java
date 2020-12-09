package com.panda.utils_test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//����ImportSelector �ӿڵ�ʵ��,������һ���������棬ͨ��import���룬�Ϳ���ע�뵽ioc����
public class ImportBeanByImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.panda.utils_test.SpringImportTest.TestBean3"};
	}
}