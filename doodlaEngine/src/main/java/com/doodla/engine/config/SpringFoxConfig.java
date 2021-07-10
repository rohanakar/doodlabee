package com.doodla.engine.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.Example;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {     
    @Bean
    public Docket api() { 
    	List<RequestParameter> globalRequestParameters = new ArrayList<RequestParameter>();
    	globalRequestParameters.add(new RequestParameterBuilder()
    							.name("Authorization")
				                .description("authorisation header")
				                .in(ParameterType.HEADER)
				                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
				                .example(new Example("1", "example", null, "Bearer eY#1ck.....", null, null))
//				                .required(true)
				                .build());
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .pathMapping("").globalRequestParameters(globalRequestParameters); 
        
    }
}
