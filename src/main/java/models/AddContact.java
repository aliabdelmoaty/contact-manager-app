package models;

import java.awt.Color;

import javax.swing.*;

import utils.Images;
import utils.RoundJTextField;
import utils.RoundedBorder;

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

    // Constructor to set up the UI
    AddContact() {
        // Set up the JFrame
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        setTitle("Contacts");

        // Initialize textFields with default hints
        nameField = new RoundJTextField("Enter name", 30);
        emailField = new RoundJTextField("Enter email", 30);
        phoneField = new RoundJTextField("Enter phone", 30);
        addressField = new RoundJTextField("Enter address", 30);

        // Initialize buttons with icons, background, and text color
        addButton = new RoundedBorder("Add");
        addButton.setIcon(Images.addIconImage());
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);

        clearButton = new RoundedBorder("Clear");
        clearButton.setIcon(Images.clearImageIcon());
        clearButton.setBackground(Color.black);
        clearButton.setForeground(Color.white);

        // Initialize labels to guide user input
        labelName = new JLabel("Name");
        labelEmail = new JLabel("Email");
        labelPhone = new JLabel("Phone");
        labelAddress = new JLabel("Address");

        // Set the location of components on the JFrame
        labelName.setBounds(15, 10, 70, 15);
        nameField.setBounds(15, 30, 200, 20);

        labelEmail.setBounds(15, 60, 70, 15);
        emailField.setBounds(15, 75, 200, 20);

        labelPhone.setBounds(15, 105, 70, 15);
        phoneField.setBounds(15, 120, 200, 20);

        labelAddress.setBounds(15, 150, 80, 15);
        addressField.setBounds(15, 165, 200, 20);

        addButton.setBounds(5, 250, 90, 30);
        clearButton.setBounds(110, 250, 90, 30);

        // Add components to the JFrame
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
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AddContact();
    }
}
