package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private ConnectionDB(){

    }
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/thi";
    private static final String USE_NAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(JDBC_URL, USE_NAME, PASSWORD);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return c;
    }

}
