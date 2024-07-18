package tn.esprit.backend.configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Douane-Server Documentation")
                        .version("1.0")
                        .description("OpenAPI Documentation for douane spring boot server.")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("DOUANE-SERVER")
                                .email("kamel.htira@medianet.com.tn")))
                .addServersItem(new Server().url("http://localhost:8087").description("localhost"))
                .components(new Components()
                        .addSecuritySchemes("Bearer Auth",
                                new SecurityScheme()
                                        .name("Bearer Auth")
                                        .description("JWT Authentication Token")
                                        .scheme("bearer")
                                        .type(SecurityScheme.Type.HTTP)
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)
                        )
                );
    }
}