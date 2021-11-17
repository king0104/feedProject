//package com.example.feedproject;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//public class SwaggerConfig {
//
//    private ApiInfo apiInfo() {
//
//        return new ApiInfoBuilder()
//                .title("swagger practice")
//                .description("practice swagger config")
//                .version("1.0")
//                .build();
//    }
//
//    @Bean
//    public Docket commonApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("example")
//                .apiInfo(this.apiInfo())
//                .select()
//                // swagger api 문서로 만들기 원하는 basePackage 경로
//                .apis(RequestHandlerSelectors
//                        .basePackage("com.example.feedproject.controller"))
//                // 해당 url에 해당하는 요청만 swagger api 문서화
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//}
