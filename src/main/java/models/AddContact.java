package models;

import java.awt.Color;
import javax.swing.*;

import utils.RoundJTextField;
import utils.RoundedBorder;

public class AddContact extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private RoundedBorder saveButton;
    private JLabel labelName;
    private JLabel labelEmail;
    private JLabel labelPhone;

    AddContact() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        setTitle("Contacts");

        nameField = new RoundJTextField("Enter name",30);
        emailField = new RoundJTextField("Enter email",30);
        phoneField = new RoundJTextField("Enter phone",30);
        saveButton = new RoundedBorder("Save");
        saveButton.setBackground(Color.RED);
        labelName = new JLabel("Name");
        labelEmail = new JLabel("Email");
        labelPhone = new JLabel("Phone");
        
        labelName.setBounds(15, 10, 70, 10);
        nameField.setBounds(15, 25, 200, 20);

        labelEmail.setBounds(15, 55, 70, 10);
        emailField.setBounds(15, 70, 200, 20);
        labelPhone.setBounds(15, 100, 70, 10);
        phoneField.setBounds(15, 115, 200, 20);

        saveButton.setBounds(5, 250, 70, 30);
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true));
        add(nameField);
        add(emailField);
        add(phoneField);
        add(saveButton);
        add(labelName);
        add(labelEmail);
        add(labelPhone);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AddContact();
    }
}
