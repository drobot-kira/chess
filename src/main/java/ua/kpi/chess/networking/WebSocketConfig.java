package ua.kpi.chess.networking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(makeMoveWebSocket(), "/chess").setAllowedOrigins("*");
    }

    @Bean
    public MakeMoveWebSocket makeMoveWebSocket() {
        return new MakeMoveWebSocket();
    }
}

