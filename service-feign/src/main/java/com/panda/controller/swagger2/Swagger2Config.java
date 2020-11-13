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
				// Ϊ��ǰ���µ�controller����API�ĵ�
				//.apis(RequestHandlerSelectors.basePackage("com.panda.controller"))
				
				  // Ϊ��apiע���controller����api�ĵ�
				  .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				  //Ϊ��@ApiOperationע��ķ�������API�ĵ�
				  //.apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))
				 
                .paths(PathSelectors.any())
                .build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("panda��Ŀ�ӿ��ĵ�")
				.description("panda document")
				.contact("panda")
				.version("1.0")
				.build();
	}
}
