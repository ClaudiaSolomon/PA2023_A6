package org.example.Lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String URL =
            "jdbc:mysql://localhost:3306/java";
    private static final String USER = "claudia";
    private static final String PASSWORD = "claudia";
    private static Connection connection = null;
    DataBase() {}
    public static Connection getConnection() {
        if(connection==null){
            createConnection();
        }
        return connection;
    }
    public static void rollback() throws SQLException {
        connection.rollback();
    }
    private static void createConnection() {
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection() throws SQLException {
        if(connection!=null&&!connection.isClosed())
            connection.close();
         }
}
