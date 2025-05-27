package ua.kpi.chess.authorization;

import ua.kpi.chess.databaseinteraction.DatabaseHandler;
import java.sql.ResultSet;

public class Authorization {

    public static byte LogIn(String name, String password) {
        try {
            DatabaseHandler dbHandler = new DatabaseHandler();
            ResultSet result = dbHandler.GetUser(name);
            if(result.next()){
                String correctPassword = result.getString("password");
                if(password.equals(correctPassword)){
                    return 1;
                }
            }
            return -1;
        }
        catch (Exception e){
            return 0;
        }
    }

    public static byte SignUp(String name, String password) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet result = dbHandler.GetUser(name);
        try {
            if (result.next()) {
                return -1;
            }
            dbHandler.AddUser(name, password);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
