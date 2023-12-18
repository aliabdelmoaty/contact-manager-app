package models;

import java.awt.Color;

import javax.swing.*;

import utils.*;
import utils.RoundJTextField;

public class LabelsAndTextFields extends JPanel {
    private JLabel labelName;
    private JLabel labelEmail;
    private JLabel labelPhone;
    private JLabel labelAddress;

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    public LabelsAndTextFields() {
        initializeComponents();
        this.setLayout(null);
        setBoundsComponents();
        addComponents();
        setBackground(Color.blue);
        // setSize(300, 300);
        setVisible(true);

    }

    private void initializeComponents() {
        labelName = new JLabel("Name");
        labelEmail = new JLabel("Email");
        labelPhone = new JLabel("Phone");
        labelAddress = new JLabel("Address");
        
        nameField = new RoundJTextField(Hints.hintName, 30);
        emailField = new RoundJTextField(Hints.hintEmail, 30);
        phoneField = new RoundJTextField(Hints.hintPhone, 30);
        addressField = new RoundJTextField(Hints.hintAddress, 30);
    }

    private void setBoundsComponents() {
        labelName.setBounds(10, 10, 50, 30);
        nameField.setBounds(10, 40, 190, 25);
        labelEmail.setBounds(10, 65, 50, 30);
        emailField.setBounds(10, 95, 190, 25);
        labelPhone.setBounds(10, 120, 50, 30);
        phoneField.setBounds(10, 150, 190, 25);
        labelAddress.setBounds(10, 175, 50, 30);
        addressField.setBounds(10, 205, 190, 25);
    }

    private void addComponents() {
        this.add(labelName);
        this.add(nameField);
        this.add(labelEmail);
        this.add(emailField);
        this.add(labelPhone);
        this.add(phoneField);
        this.add(labelAddress);
        this.add(addressField);
    }


    public String getName(){
        return nameField.getText();
    }
    public String getEmail(){
        return emailField.getText();
    }
    public String getPhone(){
        return phoneField.getText();
    }
    public String getAddress(){
        return addressField.getText();
    }

    public void setName(String name){
        nameField.setText(name);
    }
    public void setEmail(String email){
        emailField.setText(email);
    }
    public void setPhone(String phone){
        phoneField.setText(phone);
    }
    public void setAddress(String address){
        addressField.setText(address);
    }
}