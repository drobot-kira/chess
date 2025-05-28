package ua.kpi.chess.databaseinteraction;

public class Const {
    public static final String USER_TABLE = "user";
    public static final String USER_NAME = "name";
    public static final String USER_PASSWORD = "password";

    public static final String GAME_TABLE = "game";
    public static final String GAME_GAMEID = "gameId";
    public static final String GAME_WHITENAME = "whiteName";
    public static final String GAME_BLACKNAME = "blackName";
    public static final String GAME_TYPE = "type";
    public static final String GAME_MOVES = "moves";
    public static final String GAME_RESULT = "result";
    public static final String GAME_SPECTATORNAME = "spectatorName";

    public static final String POSITION_TABLE = "positiontable";
    public static final String POSITION_GAMEID = "gameId";
    public static final String POSITION_POSITION = "position";
    public static final String POSITION_REPEATCOUNTER = "repeatCounter";

    public static final String SPECTATOR_TABLE = "spectator";
    public static final String SPECTATOR_GAMEID = "gameId";
    public static final String SPECTATOR_SPECTATORNAME = "spectatorName";
}
