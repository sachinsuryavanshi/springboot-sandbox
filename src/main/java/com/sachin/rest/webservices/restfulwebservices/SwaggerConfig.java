package com.sachin.rest.webservices.restfulwebservices;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //== Custom Default Contact
    public static final Contact DEFAULT_CONTACT = new Contact("Sachin Suryavanshi",
            "https://sachinsuryavanshi.wordpress.com/",
            "sachin.suryavanshi@outlook.com");

    //== Custom Default API information
    public static final ApiInfo DEFALUT_API_INFO = new ApiInfo("Api Documentation",
            "Web API Documentation",
            "1.0",
            "urn:tos",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<VendorExtension>());

    //== Adding XML & JSON for Consumes & Produce type
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json", "application/xml"));


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFALUT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
