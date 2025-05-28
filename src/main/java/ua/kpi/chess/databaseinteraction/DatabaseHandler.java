package ua.kpi.chess.databaseinteraction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public void InitializeDatabase(String resourceName) throws SQLException, IOException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/";
        InputStream inputStream = DatabaseHandler.class.getClassLoader().getResourceAsStream(resourceName);

        if (inputStream == null) {
            throw new FileNotFoundException("Resource file not found: " + resourceName);
        }

        String sql = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        try (Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPass);
             Statement stmt = conn.createStatement()) {
            for (String command : sql.split(";")) {
                if (!command.trim().isEmpty()) {
                    stmt.execute(command);
                }
            }
        }
    }

    public Connection GetDbConnection() throws ClassNotFoundException, SQLException, IOException {
//        initializeDatabase("schema.sql");

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" +dbName;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void AddUser(String name, String password) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_PASSWORD + ")" + "VALUES(?,?)";

        try {
            PreparedStatement prSt = GetDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, password);
            prSt.executeUpdate();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet GetUser(String name){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_NAME + "=?";

        try {
            PreparedStatement prSt = GetDbConnection().prepareStatement(select);
            prSt.setString(1, name);

            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public String GetMoves(int GameId){
        String query = "SELECT " + Const.GAME_MOVES + " FROM " + Const.GAME_TABLE + " WHERE " + Const.GAME_GAMEID + " =?";

        ResultSet resultSet = null;
        String moves = null;

        try {
            PreparedStatement prSt = GetDbConnection().prepareStatement(query);
            prSt.setInt(1, GameId);
            resultSet = prSt.executeQuery();

            if (resultSet.next()) {
                moves = resultSet.getString(Const.GAME_MOVES);
            }

        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        return moves;
    }

    public void WriteMoves(int GameId, String value){
        String query = "UPDATE " + Const.GAME_TABLE + " SET " + Const.GAME_MOVES + " = " + "'"+value+"'" + " WHERE " + Const.GAME_GAMEID + " =?";

        try {
            PreparedStatement prSt = GetDbConnection().prepareStatement(query);
            prSt.setInt(1, GameId);
            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> GetInfoOfUnstartedGames() {
        ResultSet result = null;
        String checkBlackName = "bye";
        String select = "SELECT " + Const.GAME_GAMEID + ", " + Const.GAME_WHITENAME + ", " + Const.GAME_TYPE + " FROM " + Const.GAME_TABLE + " WHERE " + Const.GAME_BLACKNAME + "=?";

        try {
            PreparedStatement prSt = GetDbConnection().prepareStatement(select);
            prSt.setString(1, checkBlackName);
            result = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String[]> infoOfUnstartedGames = new ArrayList<>();

        try {
            while(result.next()){
                String[] infoOfGame = new String[3];
                infoOfGame[0] = result.getString(Const.GAME_GAMEID);
                infoOfGame[1] = result.getString(Const.GAME_WHITENAME);
                infoOfGame[2] = result.getString(Const.GAME_TYPE);
                infoOfUnstartedGames.addLast(infoOfGame);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return infoOfUnstartedGames;
    }

    
}

