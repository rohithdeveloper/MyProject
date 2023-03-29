package com.example.demo;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public Docket swaggerConfiguration() {

	return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
	.apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers")).build().apiInfo(apiInfo());

	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {

	return new ApiInfoBuilder().title("Demo Session")
	.description("Demo Session")
	.termsOfServiceUrl("http://godknows.com")
	.contact("shivani@gmail.com").license("My License")
	.licenseUrl("shivani@gmail.com").version("1.0").build();
	}
}
