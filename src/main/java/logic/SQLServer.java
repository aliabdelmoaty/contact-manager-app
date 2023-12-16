package logic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.HandleErrors;

public class SQLServer {
    private static final String JDBC_URL = "jdbc:mysql://localhost/contacts";
    private static final String userName = "root";
    private static final String password = "";
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    
    public static void connectToDatabase()throws HandleErrors{
        try {
            connection = DriverManager.getConnection(JDBC_URL, userName, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
            new HandleErrors("Error connecting to the database. Please check your network connection or server status.");

        }
    }

    public static void createTable() throws HandleErrors  {
        try {
            connectToDatabase();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS myContacts (name TEXT NOT NULL, email TEXT NOT NULL, phone INTEGER NOT NULL, address TEXT)");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
             throw new HandleErrors("Error creating table: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    public static void insertData(String name, String email, int phone, String address) throws HandleErrors {
        try {
            connectToDatabase();
            if (connection != null) {
                preparedStatement = connection
                        .prepareStatement("INSERT INTO myContacts(name ,email,phone,address) VALUES (?, ?, ?,?)");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setInt(3, phone);
                preparedStatement.setString(4, address);
                preparedStatement.executeUpdate();
            } else {
                throw new HandleErrors(" Please check your network connection or server status.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
            e.printStackTrace();
            throw new HandleErrors("Error inserting data: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    // Close resources (connection, statement, preparedStatement, etc.)
    private static void closeResources() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}
