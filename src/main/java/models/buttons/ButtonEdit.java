package models.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import logic.SQLServer;
import models.*;

import utils.Button;
import utils.HandleErrors;
import utils.Validation;

// Custom JPanel for Edit and Delete buttons
public class ButtonEdit extends JPanel {
    private JButton editButton;
    private JButton deleteButton;
    public Table table;

    // Constructor for ButtonEdit
    public ButtonEdit(Table table) {
        initializeButtons();
        setBoundsComponents();
        addComponents();
        actionButtons();
        this.table = table;
        this.setLayout(null);
        setVisible(true);
    }

    // Set the bounds for the buttons
    private void setBoundsComponents() {
        editButton.setBounds(10, 10, 90, 30);
        deleteButton.setBounds(200, 10, 90, 30);
    }

    // Add buttons to the panel
    private void addComponents() {
        add(deleteButton);
        add(editButton);
    }

    // Initialize the Edit and Delete buttons
    private void initializeButtons() {
        editButton = new Button("Edit");
        editButton.setBackground(Color.black);
        editButton.setForeground(Color.white);

        deleteButton = new Button("Delete");
        deleteButton.setBackground(Color.black);
        deleteButton.setForeground(Color.white);
    }

    // Set action listeners for Edit and Delete buttons
    private void actionButtons() {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected row data from the table
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                    String name = table.getValueAt(selectedRow, 1).toString();
                    String email = table.getValueAt(selectedRow, 2).toString();
                    String phoneString = table.getValueAt(selectedRow, 3).toString();
                    int phone = Integer.parseInt(phoneString);
                    String address = table.getValueAt(selectedRow, 4).toString();

                    // Validate user input
                    if (Validation.validationName(name)) {
                        if (Validation.validationEmail(email)) {
                            if (Validation.validationPhone(phoneString)) {
                                if (Validation.validationAddress(address)) {
                                    try {
                                        // Ask for confirmation before editing
                                        int option = JOptionPane.showConfirmDialog(getRootPane(),
                                                "Do you want to Edit this contact ", "Edit", JOptionPane.YES_NO_OPTION);
                                        if (option == JOptionPane.YES_OPTION) {
                                            // Edit the contact in the database
                                            SQLServer.editContact(id, name, email, phone, address);
                                            JOptionPane.showMessageDialog(null, "Contact edited successfully");
                                        }
                                    } catch (HandleErrors e1) {
                                        e1.printStackTrace();
                                        JOptionPane.showMessageDialog(null, e);
                                    }
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
                } else {
                    JOptionPane.showMessageDialog(getRootPane(), "Please select a row");
                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected row data from the table
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());

                    try {
                        // Ask for confirmation before deleting
                        int option = JOptionPane.showConfirmDialog(getRootPane(),
                                "Do you want to delete this contact ", "delete", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            // Delete the contact from the database and update the table
                            SQLServer.deleteContact(id);
                            table.deleteContact(selectedRow);
                            JOptionPane.showMessageDialog(null, "Contact deleted successfully");
                        }
                    } catch (HandleErrors e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, e1);
                    }
                }else{
                    JOptionPane.showMessageDialog(getRootPane(), "Please select a row");
                }

            }
        });
    }
}
