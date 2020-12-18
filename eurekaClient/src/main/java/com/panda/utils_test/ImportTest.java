package com.panda.utils_test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.panda.utils_test.SpringImportTest.TestBean1;


@Import({TestBean1.class,
		ImportBeanByImportSelector.class,
		ImportBeanByImportBeanDefinitionRegistrar.class
		})
@Configuration
public class ImportTest {

}
