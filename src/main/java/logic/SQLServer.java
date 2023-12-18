package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import models.Table;
import utils.HandleErrors;

public class SQLServer {
    private static final String JDBC_URL = "jdbc:mysql://localhost/contacts";
    private static final String userName = "root";
    private static final String password = "";
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;

    public static void connectToDatabase() throws HandleErrors {
        try {
            connection = DriverManager.getConnection(JDBC_URL, userName, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
            new HandleErrors(
                    "Error connecting to the database. Please check your network connection or server status.");

        }
    }

    public static void createContactTable() throws HandleErrors {
        try {
            connectToDatabase();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS contacts (id INT AUTO_INCREMENT PRIMARY KEY, name TEXT NOT NULL, email TEXT NOT NULL, phone INTEGER NOT NULL, address TEXT NOT NULL, time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
            throw new HandleErrors("Error creating table: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    // Function to insert the name, email, phone, and address, while the id is
    // automatically generated
    public static void insertContact(String name, String email, int phone, String address) throws HandleErrors {
        try {
            connectToDatabase();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO contacts(name, email, phone, address) VALUES (?, ?, ?, ?)");
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

    // Function to delete a contact by id
    public static void deleteContact(int id) throws HandleErrors {
        try {
            connectToDatabase();
            preparedStatement = connection.prepareStatement("DELETE FROM contacts WHERE id = ?");
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new HandleErrors("No record found for the specified id: " + id);
            }
        } catch (SQLException e) {
            throw new HandleErrors("Error deleting data: " + e.getMessage());
        } finally {
            closeResources();
        }
    }
        // Function to get a contact 
        // Function to get a contact
        public static void getContact(Table table) throws HandleErrors {
            try {
                connectToDatabase();
                preparedStatement = connection.prepareStatement("SELECT * FROM contacts");
                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                
                while (resultSet.next()) {
                    String[] data = new String[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        data[i - 1] = resultSet.getString(i);
                    }
                    table.addRow(data);
                }
            } catch (SQLException e) {
                throw new HandleErrors("Error retrieving data: " + e.getMessage());
            } finally {
                closeResources();
            }
        }

    // Function to edit contact data by id
    public static void editContact(int id, String newName, String newEmail, int newPhone, String newAddress)
            throws HandleErrors {
        try {
            connectToDatabase();
            preparedStatement = connection.prepareStatement(
                    "UPDATE contacts SET  name = ?, email = ?, phone = ?, address = ? WHERE id = ?");
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newEmail);
            preparedStatement.setInt(3, newPhone);
            preparedStatement.setString(4, newAddress);
            preparedStatement.setInt(5, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new HandleErrors("No record found for the specified id: " + id);
            }
        } catch (SQLException e) {
            throw new HandleErrors("Error updating data: " + e.getMessage());
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
