package ua.kpi.chess.authorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.kpi.chess.databaseinteraction.DatabaseHandler;
import java.sql.ResultSet;

public class Authorization {
    private static Logger logger = LoggerFactory.getLogger(Authorization.class);

    public static byte LogIn(String name, String password) {
        try {
            DatabaseHandler dbHandler = new DatabaseHandler();
            ResultSet result = dbHandler.GetUser(name);
            if(result.next()){
                String correctPassword = result.getString("password");
                if(password.equals(correctPassword)){
                    logger.info("Successful log in");
                    return 1;
                }
            }
            logger.warn("Unsuccessful log in");
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
                logger.warn("Unsuccessful registration");
                return -1;
            }
            dbHandler.AddUser(name, password);
            logger.info("Successful registration");
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
