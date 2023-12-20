package main.java;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.SQLServer;
import models.LabelsAndTextFields;
import models.Table;
import models.buttons.SearchButton;
import utils.LinePanel;
import models.buttons.ButtonEdit;
import models.buttons.ButtonsAdd;

public class Project extends JFrame {

    // Constructor for the main Project class
    public Project(LabelsAndTextFields labelsAndTextFields, ButtonsAdd buttonsAdd, Table table,
            ButtonEdit buttonEdit, SearchButton searchButton) {
        LinePanel linePanel = new LinePanel();
        setTitle("Project"); // Set the title of the JFrame
        setSize(900, 600); // Set the size of the JFrame
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setLayout(null); // Set the layout of the JFrame to null
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Set default close operation
        setResizable(false);
        labelsAndTextFields.setBounds(0, 0, 210, 240); // Set bounds for LabelsAndTextFields panel
        buttonsAdd.setBounds(0, 0, 210, 280); // Set bounds for ButtonsAdd panel
        linePanel.setBounds(215, 0, 2, 600);
        table.setBounds(230, 80, 700, 400); // Set bounds for Table panel
        buttonEdit.setBounds(300, 500, 300, 200); // Set bounds for ButtonEdit panel
        searchButton.setBounds(230, 10, 650, 50); // Set bounds for SearchButton panel

        // Add components to the JFrame
        this.add(linePanel);
        this.add(labelsAndTextFields);
        this.add(buttonsAdd);
        this.add(searchButton);

        this.add(table);
        this.add(buttonEdit);

        setVisible(true); // Set the JFrame as visible
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Create instances of necessary components (Table, LabelsAndTextFields,
        // ButtonsAdd, ButtonEdit, SearchButton)
        Table table = new Table();
        LabelsAndTextFields labelsAndTextFields = new LabelsAndTextFields();
        ButtonsAdd buttons = new ButtonsAdd(labelsAndTextFields, table);
        ButtonEdit buttonEdit = new ButtonEdit(table);
        SearchButton searchButton = new SearchButton(table);

        // Create and display a loading dialog to indicate that the program is loading
        // data
        LoadingDialog loadingDialog = new LoadingDialog();
        loadingDialog.setVisible(true);

        try {
            if (SQLServer.doesTableExist("contacts") == true) {
                // Attempt to get contact data from the SQL server and populate the table
                SQLServer.getContact(table);
            } else {
                SQLServer.createContactTable();
            }

            // Create a new instance of the Project class, passing in the necessary
            // components
            new Project(labelsAndTextFields, buttons, table, buttonEdit, searchButton);
        } catch (Exception e) {
            // If an exception occurs, display an error message to the user
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error getting contacts. Please check your server.", "Error!",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            // Hide and dispose of the loading dialog, regardless of whether an exception
            // occurred
            loadingDialog.setVisible(false);
            loadingDialog.dispose();
        }
    }

    // Nested static class for the loading dialog
    static class LoadingDialog extends JFrame {
        public LoadingDialog() {
            JLabel label = new JLabel();
            label.setText("Loading....");
            JPanel panel = new JPanel();
            panel.add(label);
            this.add(panel);
            setResizable(false);
            setUndecorated(true);
            setSize(150, 50);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
