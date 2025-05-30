package ua.kpi.chess.networking;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ua.kpi.chess.authorization.Authorization;
import ua.kpi.chess.databaseinteraction.DatabaseHandler;
import ua.kpi.chess.server.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class ControllerWebSocket extends TextWebSocketHandler {

    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final Map<WebSocketSession, String> sessionUserNames = new ConcurrentHashMap<>();

    private WebSocketSession findSessionByUserName(String userName) {
        for (Map.Entry<WebSocketSession, String> entry : sessionUserNames.entrySet()) {
            WebSocketSession session = entry.getKey();
            String name = entry.getValue();
            if (session.isOpen() && userName.equals(name)) {
                return session;
            }
        }
        return null;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        sessionUserNames.remove(session);
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        JsonNode jsonNode = objectMapper.readTree(payload);

        String type = jsonNode.get("Type").asText();

        if (type.equals("SquareClicked")) {
            byte squareId = (byte) jsonNode.get("SquareId").asInt();
            int gameId = jsonNode.get("GameId").asInt();
            String userId = jsonNode.get("UserId").asText();

            Game game = new Game();
            byte[][] field = game.SquareClicked(gameId, squareId, userId);

            int[][] intField = new int[field.length][field[0].length];
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    intField[i][j] = field[i][j];
                }
            }

            String jsonResponse = objectMapper.writeValueAsString(intField);
            session.sendMessage(new TextMessage(jsonResponse));
        }
        else if (type.equals("Identify")) {
            String userName = jsonNode.get("UserName").asText();
            sessionUserNames.put(session, userName);
        }
        else if (type.equals("LogIn")) {
            String name = jsonNode.get("Name").asText();
            String password = jsonNode.get("Password").asText();

            byte output = Authorization.LogIn(name, password);
            String jsonResponse = objectMapper.writeValueAsString(output);

            session.sendMessage(new TextMessage(jsonResponse));
        }
        else if (type.equals("SignUp")) {
            String name = jsonNode.get("Name").asText();
            String password = jsonNode.get("Password").asText();

            byte output = Authorization.SignUp(name, password);
            String jsonResponse = objectMapper.writeValueAsString(output);

            session.sendMessage(new TextMessage(jsonResponse));
        }
        else if (type.equals("CreateGame")) {
            String userName = jsonNode.get("UserName").asText();
            String gameType = jsonNode.get("GameType").asText();

            sessionUserNames.put(session, userName);

            DatabaseHandler databaseHandler = new DatabaseHandler();
            databaseHandler.CreateGame(userName, gameType);

            List<String[]> updatedGames = databaseHandler.GetInfoOfUnstartedGames();

            Map<String, Object> response = new HashMap<>();
            response.put("type", "AvailableGames");
            response.put("games", updatedGames);
            String jsonResponse = objectMapper.writeValueAsString(response);

            for (WebSocketSession s : sessions) {
                if (s.isOpen()) {
                    s.sendMessage(new TextMessage(jsonResponse));
                }
            }
        }
        else if (type.equals("GetUnstartedGames")) {
            DatabaseHandler databaseHandler = new DatabaseHandler();
            List<String[]> unstartedGames = databaseHandler.GetInfoOfUnstartedGames();

            Map<String, Object> response = new HashMap<>();
            response.put("type", "AvailableGames");
            response.put("games", unstartedGames);

            String jsonResponse = objectMapper.writeValueAsString(response);
            session.sendMessage(new TextMessage(jsonResponse));
        }
        else if (type.equals("StartGame")) {
            int gameId = jsonNode.get("GameId").asInt();
            String userName = jsonNode.get("UserName").asText();
            DatabaseHandler databaseHandler = new DatabaseHandler();
            String[] players = databaseHandler.StartGame(gameId, userName);

            WebSocketSession creatorSession = findSessionByUserName(players[0]);
            System.out.println(players[0]);
            if (creatorSession != null && creatorSession.isOpen()) {
                Map<String, Object> response = new HashMap<>();
                response.put("type", "StartGame");
                response.put("color", "white");
                response.put("gameid", gameId);
                response.put("opponent", players[1]);
                String jsonResponse = objectMapper.writeValueAsString(response);
                creatorSession.sendMessage(new TextMessage(jsonResponse));
            }

            WebSocketSession opponentSession = findSessionByUserName(players[1]);
            if (opponentSession != null && opponentSession.isOpen()) {
                Map<String, Object> response = new HashMap<>();
                response.put("type", "StartGame");
                response.put("color", "black");
                response.put("gameid", gameId);
                response.put("opponent", players[0]);
                String jsonResponse = objectMapper.writeValueAsString(response);
                opponentSession.sendMessage(new TextMessage(jsonResponse));
            }
        }
    }
}
