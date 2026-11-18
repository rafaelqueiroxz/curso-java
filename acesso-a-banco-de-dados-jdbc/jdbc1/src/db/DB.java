package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection(){
        if (connection == null){
            try {
                Properties prop = loadProperties();
                String url = prop.getProperty("dburl");
                connection = DriverManager.getConnection(url, prop);
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
        return connection;
    }

    private static Properties loadProperties() {

        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(fs);
            return prop;
        } catch (IOException e) {
            throw new DBException(e.getMessage());
        }
    }

    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e){
                throw new DBException(e.getMessage());
            }
        }
    }

}
