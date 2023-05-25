package api;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Laborator11", version = "v1"),
        servers = {@Server(url = "http://localhost:8081")},
        tags = {
                @Tag(name = "Player", description = "Players of the games"),
                @Tag(name = "Game", description = "Games running ")
        })
public class SwaggerConfig {
}
