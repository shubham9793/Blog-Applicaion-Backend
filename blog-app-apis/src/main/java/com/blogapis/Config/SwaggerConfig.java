package com.blogapis.Config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfo()).select().
                apis(RequestHandlerSelectors.any()).
                paths(PathSelectors.any()).build();
    }

    private ApiInfo getInfo() {
        return new ApiInfo("Blogging Application Backend ","This is developed by Shubham",
                "1.0","Terms of service",
                new Contact("shubham","https://learncodewithdurgesh.com","shubham9793@gmail.com"),
                "License of APIS","Api license url", Collections.emptyList());
    }
}
