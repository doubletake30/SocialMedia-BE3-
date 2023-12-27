package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/socialmedia(be3)";
    private static final String USER = "root";
    private static final String PASSWORD = "Thanhtri291104@";

    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            c = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
