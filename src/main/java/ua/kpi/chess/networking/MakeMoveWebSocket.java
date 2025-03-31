package ua.kpi.chess.networking;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ua.kpi.chess.server.Game;

@Component
public class MakeMoveWebSocket extends TextWebSocketHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        JsonNode jsonNode = objectMapper.readTree(payload);

        int squareId = jsonNode.get("SquareId").asInt();
        int gameId = jsonNode.get("GameId").asInt();
        int userId = jsonNode.get("UserId").asInt();

        Game game = new Game();
        byte[][] field = game.SquareClicked(gameId, squareId, userId);


        int[][] intField = new int[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                intField[i][j] = Byte.toUnsignedInt(field[i][j]);
            }
        }

        String jsonResponse = objectMapper.writeValueAsString(intField);

        session.sendMessage(new TextMessage(jsonResponse));
    }
}
