package ua.kpi.chess.networking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.kpi.chess.databaseinteraction.DatabaseHandler;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class WebSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
        DatabaseHandler dbHandler = new DatabaseHandler();
        try {
            dbHandler.InitializeDatabase("schema.sql");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}