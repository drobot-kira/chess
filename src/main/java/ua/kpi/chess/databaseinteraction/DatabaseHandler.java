package ua.kpi.chess.databaseinteraction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        String query = "UPDATE " + Const.GAME_TABLE + " SET " + Const.GAME_MOVES + " = " + "'* "+value+"'" + " WHERE " + Const.GAME_GAMEID + " =?";

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

    public List<String[]> GetInfoOfNotFinishedGames() {
        ResultSet result = null;
        String checkBlackName = "bye";
        String select = "SELECT " + Const.GAME_GAMEID + ", " + Const.GAME_WHITENAME + ", " + Const.GAME_BLACKNAME + ", " + Const.GAME_TYPE + " FROM " + Const.GAME_TABLE + " WHERE " + Const.GAME_BLACKNAME + "!=? AND " + Const.GAME_RESULT + " IS NULL";

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
        List<String[]> infoOfNotFinishedGames = new ArrayList<>();
        try {
            while(result.next()){
                String[] infoOfGame = new String[4];
                infoOfGame[0] = result.getString(Const.GAME_GAMEID);
                infoOfGame[1] = result.getString(Const.GAME_WHITENAME);
                infoOfGame[2] = result.getString(Const.GAME_BLACKNAME);
                infoOfGame[3] = result.getString(Const.GAME_TYPE);
                infoOfNotFinishedGames.addLast(infoOfGame);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return infoOfNotFinishedGames;
    }

    public boolean AddSpectator(int gameId, String spectatorName){
        String insert = "INSERT INTO " + Const.SPECTATOR_TABLE + "(" + Const.SPECTATOR_GAMEID + "," + Const.SPECTATOR_SPECTATORNAME + ")" + "VALUES(?,?)";

        try {
            PreparedStatement prSt = GetDbConnection().prepareStatement(insert);
            prSt.setInt(1, gameId);
            prSt.setString(2, spectatorName);
            prSt.executeUpdate();
        } catch (SQLException | IOException e) {
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private boolean IsIdenticalGameId(int gameId){
        String query = "SELECT " + Const.GAME_GAMEID + " FROM " + Const.GAME_TABLE + " WHERE " + Const.GAME_GAMEID + "= ?";

        try (PreparedStatement stmt =  GetDbConnection().prepareStatement(query)) {
            stmt.setLong(1, gameId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void CreateGame(String userName, String type){
        ResultSet resultSet = null;
        String bye = null;
        try {
            resultSet = GetUser("bye");
            if(resultSet.next()){
                bye = resultSet.getString(Const.USER_NAME);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(bye == null){
            AddUser("bye", "");
        }

        var random = new Random();
        int gameId = random.nextInt(0,1000000);
        while(IsIdenticalGameId(gameId)){
            gameId += random.nextInt(0, 1000000);
        }

        String insert = "INSERT INTO " + Const.GAME_TABLE + "(" + Const.GAME_GAMEID + "," + Const.GAME_WHITENAME + "," + Const.GAME_BLACKNAME + "," + Const.GAME_TYPE+ ")" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = GetDbConnection().prepareStatement(insert);
            prSt.setInt(1, gameId);
            prSt.setString(2, userName);
            prSt.setString(3, "bye");
            prSt.setString(4, type);
            prSt.executeUpdate();
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private ResultSet GetGame(int gameId){
        String select = "SELECT * FROM " + Const.GAME_TABLE + " WHERE " + Const.GAME_GAMEID + " = " + gameId;
        ResultSet resultSet = null;

        try {
            PreparedStatement prSt = GetDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }
    private void UpdateUsers(int GameId, String valueWhiteName, String valueBlackName){
        String updateWhite = "UPDATE " + Const.GAME_TABLE + " SET " + Const.GAME_WHITENAME + " = " + "'"+valueWhiteName+"'" + " WHERE " + Const.GAME_GAMEID + " =?";
        String updateBlack = "UPDATE " + Const.GAME_TABLE + " SET " + Const.GAME_BLACKNAME + " = " + "'"+valueBlackName+"'" + " WHERE " + Const.GAME_GAMEID + " =?";

        try {
            PreparedStatement prStWhite = GetDbConnection().prepareStatement(updateWhite);
            prStWhite.setInt(1, GameId);
            prStWhite.executeUpdate();

            PreparedStatement prStBlack = GetDbConnection().prepareStatement(updateBlack);
            prStBlack.setInt(1, GameId);
            prStBlack.executeUpdate();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String[] StartGame(int gameId, String UserName){
        ResultSet resultSet = null;
        String WhiteName = null;
        String BlackName = null;
        try {
            resultSet = GetGame(gameId);
            if (resultSet.next()) {
                WhiteName = resultSet.getString(Const.GAME_WHITENAME);
                BlackName = resultSet.getString(Const.GAME_BLACKNAME);
            }
            else{
                return new String[]{"Error1", "Error"};
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(WhiteName.equals(UserName)){
            return new String[]{"Error2", "Error"};
        }else if(!BlackName.equals("bye")){
            return new String[]{"Error3", "Error"};
        }

        var random = new Random();
        byte colorWhite = 2;//(byte)random.nextInt(1, 3);
        if(colorWhite == 1){
            UpdateUsers(gameId, WhiteName, UserName);
            return new String[]{WhiteName, UserName};
        }else{
            UpdateUsers(gameId, UserName, WhiteName);
            return new String[]{UserName, WhiteName};
        }
    }
    public boolean EndGame(int gameId, int result){
        String deleteCounter = "DELETE FROM " + Const.POSITION_TABLE + " WHERE " + Const.GAME_GAMEID + " = " + gameId;
        String updateSpectator = "UPDATE " + Const.GAME_TABLE + " SET " + Const.GAME_SPECTATORNAME + " = " + "NULL" + " WHERE " + Const.GAME_GAMEID + " = " + gameId;
        String updateResult = "UPDATE " + Const.GAME_TABLE + " SET " + Const.GAME_RESULT + " = " + "'" + result + "'" + " WHERE " + Const.GAME_GAMEID + " = " + gameId;
        String deleteSpectator = "DELETE FROM " + Const.SPECTATOR_TABLE + " WHERE " + Const.GAME_GAMEID + " = " + gameId;

        try{
            PreparedStatement stmtCounter =  GetDbConnection().prepareStatement(deleteCounter);
            PreparedStatement stmtSpectator =  GetDbConnection().prepareStatement(updateSpectator);
            PreparedStatement stmtResult =  GetDbConnection().prepareStatement(updateResult);
            PreparedStatement stmtDeleteSpectator =  GetDbConnection().prepareStatement(deleteSpectator);
            stmtCounter.executeUpdate();
            stmtSpectator.executeUpdate();
            stmtResult.executeUpdate();
            stmtDeleteSpectator.executeUpdate();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public int GetRepeatCounter(int gameId, String position){
        String select = "SELECT " + Const.POSITION_REPEATCOUNTER + " FROM " + Const.POSITION_TABLE + " WHERE " + Const.POSITION_POSITION + " = ? AND " + Const.POSITION_GAMEID + " = ?";

        int repeatCounter = -1;
        try{
            PreparedStatement prSt = GetDbConnection().prepareStatement(select);
            prSt.setString(1, position);
            prSt.setInt(2, gameId);
            ResultSet rs = prSt.executeQuery();
            if (rs.next()) {
                repeatCounter = rs.getInt("repeatCounter");
            }
        }
        catch(SQLException | ClassNotFoundException | IOException e){
            throw new RuntimeException(e);
        }
        return repeatCounter;
    }

    public void UpdatePosition(int gameId, String position){
        String update = "UPDATE " + Const.POSITION_TABLE + " SET " + Const.POSITION_REPEATCOUNTER + " = " + Const.POSITION_REPEATCOUNTER + " + 1 WHERE " + Const.POSITION_POSITION + " = ? AND " + Const.POSITION_GAMEID + " = ?";
        try{
            PreparedStatement prSt = GetDbConnection().prepareStatement(update);
            prSt.setString(1, position);
            prSt.setInt(2, gameId);
            prSt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException | IOException e){
            throw new RuntimeException(e);
        }
    }

    public void InsertPosition(int gameId, String position){
        String insert = "INSERT INTO " + Const.POSITION_TABLE + " (" + Const.POSITION_GAMEID + ", " + Const.POSITION_POSITION + ", " + Const.POSITION_REPEATCOUNTER + ") VALUES (?, ?, 1)";
        try{
            PreparedStatement prSt = GetDbConnection().prepareStatement(insert);
            prSt.setInt(1, gameId);
            prSt.setString(2, position);
            prSt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException | IOException e){
            throw new RuntimeException(e);
        }

    }

    public String GetWhiteId(int gameId) {
        String select = "SELECT " + Const.GAME_WHITENAME + " FROM " + Const.GAME_TABLE + " WHERE " + Const.GAME_GAMEID + " =  " + gameId;
        String whiteName = null;

        try{
            PreparedStatement prSt = GetDbConnection().prepareStatement(select);

            ResultSet rs = prSt.executeQuery();
            if (rs.next()) {
                whiteName = rs.getString(Const.GAME_WHITENAME);
            }
        }
        catch(SQLException | ClassNotFoundException | IOException e){
            throw new RuntimeException(e);
        }

        return whiteName;
    }

}

