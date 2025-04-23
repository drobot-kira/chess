package ua.kpi.chess.databaseinteraction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public void initializeDatabase(String resourceName) throws SQLException, IOException {
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

    public Connection getDbConnection() throws ClassNotFoundException, SQLException
    {

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" +dbName;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void AddUser(String name, String password) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_PASSWORD + ")" + "VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, password);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getUser(String name){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_NAME + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, name);

            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}

