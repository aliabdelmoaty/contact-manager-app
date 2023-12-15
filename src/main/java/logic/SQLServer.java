package logic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServer {
    private static final String JDBC_URL = "jdbc:mysql://localhost/contacts";
    private static final String userName = "root";
    private static final String password = "";
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    public static void connectToDatabase() {
        
        try {
            connection = DriverManager.getConnection(JDBC_URL, userName, password);

        }catch(SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
            
    }
    // Method for creating a table in the database
    public static void createTable() {
       
        try {
            connection = DriverManager.getConnection(JDBC_URL, userName, password);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, email TEXT, phone INTEGER, address TEXT)");
        }catch(SQLException e){
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
    // Method for inserting data into the database


    public static void insertData(String name,String email,int phone ,String address){
        try{
            connection =DriverManager.getConnection(JDBC_URL, userName, password);


            preparedStatement=connection.prepareStatement("INSERT INTO contacts(name ,email,phone,address) VALUES (?, ?, ?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    
}
