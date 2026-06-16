package com.gruapim.taskmaster.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI taskmasterOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TaskMaster API")
                        .description("API RESTful para gerenciamento de tarefas — GRUAPIM")
                        .version("1.0.0"));
    }
}
