package models;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import utils.*;
import logic.SQLServer;

public class AddContact extends JFrame {

    // TextFields for user input
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;

    // Buttons for actions
    private JButton addButton;
    private JButton clearButton;

    // Labels for guiding user input
    private JLabel labelName;
    private JLabel labelEmail;
    private JLabel labelPhone;
    private JLabel labelAddress;
    private LinePanel linePanel;
    // Constructor to set up the UI
    public AddContact() {
        // Set up the JFrame
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        setTitle("Contacts");
        linePanel = new LinePanel();
        // Initialize textFields with default hints
        textFields();

        // Initialize buttons with icons, background, and text color
        Buttons();

        // Initialize labels to guide user input
        labels();
        // Set the location of components on the JFrame
        setBounds();

        // get name and email and address and phone

        ActionButtons();

        // Add components to the JFrame
        addComponents();

        this.setVisible(true);
    }

    private void labels() {
        labelName = new JLabel("Name");
        labelEmail = new JLabel("Email");
        labelPhone = new JLabel("Phone");
        labelAddress = new JLabel("Address");

    }

    private void ActionButtons() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String address = addressField.getText();
                String phoneText = phoneField.getText();
                int phone = 0;
                if (!phoneText.equals(Hints.hintPhone)) {
                    phone = Integer.parseInt(phoneText);
                }
                // Add action listener to clear button
                try {
                    if (Validation.validationName(name) == true) {
                        if (Validation.validationEmail(email) == true) {
                            if (Validation.validationPhone(phoneText)) {
                                SQLServer.insertData(name, email, phone, address);
                                JOptionPane.showMessageDialog(rootPane, "Contact added successfully");
                                nameField.setText(Hints.hintName);
                                emailField.setText(Hints.hintEmail);
                                phoneField.setText(Hints.hintPhone);
                                addressField.setText(Hints.hintAddress);
                            } else {
                                JOptionPane.showMessageDialog(null, "Error: Invalid Phone");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: Invalid Email");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Invalid Name");
                    }
                } catch (HandleErrors error) {
                    error.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + error.getMessage());
                }

            }
        });
        clearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(rootPane, e, getTitle(), ABORT);
                int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to clear this contact ", "title",
                        JOptionPane.YES_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    nameField.setText(Hints.hintName);
                    emailField.setText(Hints.hintEmail);
                    phoneField.setText(Hints.hintPhone);
                    addressField.setText(Hints.hintAddress);
                }

            }

        });
    }

    private void textFields() {
        nameField = new RoundJTextField(Hints.hintName, 30);
        emailField = new RoundJTextField(Hints.hintEmail, 30);
        phoneField = new RoundJTextField(Hints.hintPhone, 30);
        addressField = new RoundJTextField(Hints.hintAddress, 30);
    }

    private void Buttons() {
        addButton = new Button("Add");
        addButton.setIcon(Images.addIconImage());
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);

        clearButton = new Button("Clear");
        clearButton.setIcon(Images.clearImageIcon());
        clearButton.setBackground(Color.black);
        clearButton.setForeground(Color.white);
    }

    // method set the location of components on the JFrame
    private void setBounds() {
        labelName.setBounds(15, 10, 70, 15);
        nameField.setBounds(15, 30, 200, 20);

        labelEmail.setBounds(15, 60, 70, 15);
        emailField.setBounds(15, 75, 200, 20);

        labelPhone.setBounds(15, 105, 70, 15);
        phoneField.setBounds(15, 120, 200, 20);

        labelAddress.setBounds(15, 150, 80, 15);
        addressField.setBounds(15, 165, 200, 20);

        addButton.setBounds(15, 250, 90, 30);
        clearButton.setBounds(110, 250, 90, 30);
        linePanel.setBounds(10, 0, getWidth(), getHeight());
    }

    

    // method Add components to the JFrame
    private void addComponents() {
        add(nameField);
        add(emailField);
        add(phoneField);
        add(addressField);
        add(addButton);
        add(clearButton);
        add(labelName);
        add(labelEmail);
        add(labelPhone);
        add(labelAddress);
        add(linePanel);
        // add(new setBounds());
    }

}
