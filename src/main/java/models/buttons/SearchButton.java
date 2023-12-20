package models.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logic.SQLServer;
import models.*;

import utils.Button;
import utils.Constants;
import utils.HandleErrors;
import utils.Hints;
import utils.RoundJTextField;
import utils.Validation;

public class SearchButton extends JPanel {
    private JButton search;
    private JButton clearSearch;
    private JComboBox<String> sort;
    public Table table; // Reference to the table where search results will be displayed
    private JLabel label;
    private JTextField textField;

    // Constructor for SearchButton
    public SearchButton(Table table) {
        initializeButtons(); // Initialize UI components
        setBoundsComponents(); // Set the bounds (positions and sizes) of UI components
        addComponents(); // Add UI components to the panel

        actionButtons(); // Set up action listeners for buttons
        this.table = table; // Set the reference to the table
        this.setLayout(null); // Set the layout to null for manual component positioning
        setVisible(true); // Set the panel as visible
    }

    // Set the bounds of UI components
    private void setBoundsComponents() {
        label.setBounds(10, 20, 90, 30);
        sort.setBounds(80, 20, 90, 30);
        textField.setBounds(200, 20, 220, 30);
        search.setBounds(430, 20, 90, 30);
        clearSearch.setBounds(530, 20, 110, 30);
    }

    // Add UI components to the panel
    private void addComponents() {
        add(sort);
        add(label);
        add(search);
        add(textField);
        add(clearSearch);
    }

    // Initialize UI components (buttons, labels, text fields)
    private void initializeButtons() {
        textField = new RoundJTextField(Hints.HINT_SEARCH, 30);
        textField.setFont(Constants.getFontForTextField());
        search = new Button("Search");
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        clearSearch = new Button("Clear search");
        clearSearch.setBackground(Color.black);
        clearSearch.setForeground(Color.white);
        String country[] = { "A-Z", "Z-A" };
        sort = new JComboBox<String>(country);
        label = new JLabel("Sort");
        label.setFont(Constants.getFontForLabel());
    }

    // Set up action listeners for buttons
    private void actionButtons() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform search action when the "Search" button is clicked
                String text = textField.getText();
                if (Validation.validationSearch(textField.getText())) {
                    try {
                        SQLServer.searchContactsByText(text, table); // Search contacts in the database
                        textField.setText(Hints.HINT_SEARCH);
                    } catch (HandleErrors e1) {
                        // Handle errors that may occur during the search
                        handleSearchError(e1);
                    }
                } else {
                    // Show error message if the search input is invalid
                    JOptionPane.showMessageDialog(getRootPane(), "Please enter id, name or email to search");
                }
            }
        });

        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle sorting selection when the selection in the combo box changes
                handleSortSelection();
            }
        });
        clearSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the search results when the "Clear search" button is clicked
                try {
                    table.clearTable();
                    SQLServer.getContact(table); // Get all contacts from the database
                } catch (HandleErrors e1) {
                    // Handle errors that may occur during the search
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(getRootPane(), e1.getMessage());
                }
            }
        });
    }

    // Handle errors that may occur during the search operation
    private void handleSearchError(HandleErrors e1) {
        System.out.println(e1.toString());
        if (e1.getMessage().contains("No record found")) {
            // Show a message if no records are found and try to get all contacts
            JOptionPane.showMessageDialog(getRootPane(), "No record found");
            try {
                SQLServer.getContact(table);
            } catch (HandleErrors e2) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(getRootPane(), e1.getMessage());
            }
        } else {
            // Handle other errors by showing an error message
            e1.printStackTrace();
            JOptionPane.showMessageDialog(getRootPane(), e1.getMessage());
        }
    }

    // Handle sorting based on the selected option
    private void handleSortSelection() {
        String selected = sort.getSelectedItem().toString();
        switch (selected) {
            case "A-Z":
                try {
                    SQLServer.sortAZ(table); // Sort contacts in ascending order
                } catch (HandleErrors e1) {
                    // Handle errors that may occur during sorting
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(getRootPane(), e1);
                }
                break;
            case "Z-A":
                try {
                    SQLServer.sortZA(table); // Sort contacts in descending order
                } catch (HandleErrors e1) {
                    // Handle errors that may occur during sorting
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(getRootPane(), e1);
                }
                break;
            default:
                break;
        }
    }
}
