package com.zeriter.config;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  
@EnableSwagger2
public class Swagger2Configuration {
	public static final String BASE_SCAN = "com.zeriter";
	public static final String VERSION = "1.0.0";
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_SCAN))
				.paths(PathSelectors.any())
				.build();
	}
	   private ApiInfo apiInfo() {
	       return new ApiInfoBuilder()
	                   .title("个人博客--ZBlog") //设置文档的标题
	                   .description(" API 接口文档") // 设置文档的描述
	                   .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
	                   .build();
	   }
}
