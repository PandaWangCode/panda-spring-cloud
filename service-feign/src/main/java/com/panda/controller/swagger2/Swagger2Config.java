package com.panda.controller.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				// 为当前包下的controller生成API文档
				//.apis(RequestHandlerSelectors.basePackage("com.panda.controller"))
				
				  // 为有api注解的controller生成api文档
				  .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				  //为有@ApiOperation注解的方法生成API文档
				  //.apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))
				 
                .paths(PathSelectors.any())
                .build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("panda项目接口文档")
				.description("panda document")
				.contact("panda")
				.version("1.0")
				.build();
	}
}
