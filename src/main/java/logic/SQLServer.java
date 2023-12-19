package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Result;

import models.Table;
import utils.Constants;
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
                    Constants.CREATE_CONTACT);
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
                        Constants.INSERT_CONTACT);
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
            preparedStatement = connection.prepareStatement(Constants.DELETE_CONTACT);
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
            preparedStatement = connection.prepareStatement(Constants.GET_CONTACT);
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

    /**
     * This method sorts the data in the table in ascending order (A-Z) by name.
     * It first establishes a connection to the database, then prepares and executes
     * a SQL query to fetch all contacts, ordered by name in ascending order.
     * The data from the ResultSet is then added row by row to the table.
     * If there is a SQL exception during this process, a HandleErrors exception is
     * thrown with a message detailing the error.
     */
    public static void sortAZ(Table table) throws HandleErrors {
        try {
            connectToDatabase();
            preparedStatement = connection.prepareStatement(Constants.SORT_AZ);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            table.clearTable();
            while (resultSet.next()) {
                String[] data = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getString(i);
                }
                table.addRow(data);
            }

        } catch (SQLException e) {
            throw new HandleErrors("Error retrieving data: " + e.getMessage());

        }
    }

    /**
     * This method sorts the data in the table in descending order (Z-A) by name.
     * It first establishes a connection to the database, then prepares and executes
     * a SQL query to fetch all contacts, ordered by name in descending order.
     * The data from the ResultSet is then added row by row to the table.
     * If there is a SQL exception during this process, a HandleErrors exception is
     * thrown with a message detailing the error.
     */
    public static void sortZA(Table table) throws HandleErrors {
        try {
            connectToDatabase();
            preparedStatement = connection.prepareStatement(Constants.SORT_ZA);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            table.clearTable();
            while (resultSet.next()) {
                String[] data = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getString(i);
                }
                table.addRow(data);
            }
        } catch (SQLException e) {
            throw new HandleErrors("Error retrieving data: " + e.getMessage());

        }
    }

    public static void searchContactsByText(String txt, Table table) throws HandleErrors {
        try {
            connectToDatabase();
            String searchText = "%" + txt + "%";
            preparedStatement = connection.prepareStatement(Constants.SEARCH_TEXT);
            preparedStatement.setString(1, searchText);
            preparedStatement.setString(2, searchText);
            preparedStatement.setString(3, searchText);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            System.out.println(columnCount);

            table.clearTable();
            while (resultSet.next()) {
                String[] data = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getString(i);
                }
                table.addRow(data);

            }
           int rowCount= table.getRowCount();
           if(rowCount<=0){
            throw new HandleErrors("No record found");
           }

        } catch (SQLException e) {
            throw new HandleErrors("Error retrieving data: " + e.getMessage());
        }

    }

    // Function to edit contact data by id
    public static void editContact(int id, String newName, String newEmail, int newPhone, String newAddress)
            throws HandleErrors {
        try {
            connectToDatabase();
            preparedStatement = connection.prepareStatement(
                    Constants.EDIT_CONTACT);
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
