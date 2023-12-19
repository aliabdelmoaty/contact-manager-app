package models.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.SQLServer;
import models.*;

import utils.*;

// Custom JPanel for Add and Clear buttons
public class ButtonsAdd extends JPanel {
    private JButton addButton;
    private JButton clearButton;
    public Table table;
    private LabelsAndTextFields gTextFields;

    // Constructor for ButtonsAdd
    public ButtonsAdd(LabelsAndTextFields labelsAndTextFields, Table table) {
        initializeButtons();
        this.setLayout(null);
        this.gTextFields = labelsAndTextFields;
        this.table = table;
        setBoundsComponents();
        addComponents();
        actionButtons();
        setVisible(true);
    }

    // Set the bounds for the buttons
    private void setBoundsComponents() {
        addButton.setBounds(15, 250, 90, 30);
        clearButton.setBounds(110, 250, 90, 30);
    }

    // Add buttons to the panel
    private void addComponents() {
        add(addButton);
        add(clearButton);
    }

    // Initialize the Add and Clear buttons
    private void initializeButtons() {
        addButton = new Button("Add");
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);
        clearButton = new Button("Clear");
        clearButton.setBackground(Color.black);
        clearButton.setForeground(Color.white);
    }

    // Set action listeners for Add and Clear buttons
    private void actionButtons() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Validate user input
                    if (Validation.validationName(gTextFields.getName())) {
                        if (Validation.validationEmail(gTextFields.getEmail())) {
                            if (Validation.validationPhone(gTextFields.getPhone())) {
                                if (Validation.validationAddress(gTextFields.getAddress())) {
                                    int phone;
                                    try {
                                        // Parse phone as an integer or set it to 0 if parsing fails
                                        phone = Integer.parseInt(gTextFields.getPhone());
                                    } catch (NumberFormatException numberFormatException) {
                                        phone = 0;
                                    }
                                    // Insert the contact into the database
                                    SQLServer.insertContact(gTextFields.getName(), gTextFields.getEmail(), phone,
                                            gTextFields.getAddress());
                                    JOptionPane.showMessageDialog(null, "Record added successfully", "Successful!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    // Clear and repopulate the table
                                    table.clearTable();
                                    SQLServer.getContact(table);
                                    table.repaint();
                                    resetFields();
                                } else {
                                    JOptionPane.showMessageDialog(getRootPane(), "Enter a valid address");
                                }
                            } else {
                                JOptionPane.showMessageDialog(getRootPane(), "Enter a valid phone");
                            }
                        } else {
                            JOptionPane.showMessageDialog(getRootPane(), "Enter a valid email");
                        }
                    } else {
                        JOptionPane.showMessageDialog(getRootPane(), "Enter a valid name");
                    }
                } catch (Exception e1) {
                    // Display an error message if adding the record fails
                    JOptionPane.showMessageDialog(null, "Failed to add record", "Error!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ask for confirmation before clearing fields
                int option = JOptionPane.showConfirmDialog(getRootPane(),
                        "Do you want to clear this contact ", "Delete", JOptionPane.YES_NO_OPTION,
                        JOptionPane.YES_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Reset the text fields
                    resetFields();
                }
            }
        });
    }

    // Reset the text fields to their hint values
    private void resetFields() {
        gTextFields.setName(Hints.HINT_NAME);
        gTextFields.setEmail(Hints.HINT_EMAIL);
        gTextFields.setPhone(Hints.HINT_PHONE);
        gTextFields.setAddress(Hints.HINT_ADDRESS);
    }
}
