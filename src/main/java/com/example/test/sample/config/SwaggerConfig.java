package com.example.test.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_12)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.test.sample.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .useDefaultResponseMessages(false);
    }

    @Value("${owner-name}")
    String ownerName;
    @Value("${swagger-title}")
    String title;
    @Value("${swagger-description}")
    String description;
    @Value("${swagger-api-version}")
    String apiVersion;
    @Value("${swagger-api-license}")
    String license;
    @Value("${swagger-api-term}")
    String termOfUse;

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                title,
                description,
                apiVersion,
                termOfUse,
                ownerName,
                license,
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }

    /**
     * Build security context for Swagger Codegen
     *
     * @return
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    /**
     * Swagger Scheme of token Authentication, default permission as global
     *
     * @return
     */
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
                new SecurityReference("token", authorizationScopes));
    }

    /**
     * let swagger know how to provide authentication token
     *
     * @return
     */
    public SecurityScheme apiKey() {
        return new ApiKey("token", "Authorization", "header");
    }
}
