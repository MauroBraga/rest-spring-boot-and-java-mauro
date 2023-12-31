package br.com.mrb.restspringbootandjavamauro.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {


    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Hello Swagger OpenAPI")
                        .version("v1")
                        .description("Some description about your API.")
                        .termsOfService("https://mrb.com.br/meus-cursos")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://mrb.com.br/meus-cursos")));
    }
}
