package models;

import javax.swing.*;

import utils.*;

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
        // setBackground(Color.blue);
        // setSize(300, 300);
        setVisible(true);

    }

    private void initializeComponents() {
        initializeLabels();
        nameField = new RoundJTextField(Hints.HINT_NAME, 30);
        emailField = new RoundJTextField(Hints.HINT_EMAIL, 30);
        phoneField = new RoundJTextField(Hints.HINT_PHONE, 30);
        addressField = new RoundJTextField(Hints.HINT_ADDRESS, 30);
    }

    private void initializeLabels() {
        labelName = new JLabel("Name");
        labelName.setFont(Constants.fontLabel());
        labelEmail = new JLabel("Email");
        labelEmail.setFont(labelName.getFont());
        labelPhone = new JLabel("Phone");
        labelPhone.setFont(labelName.getFont());
        labelAddress = new JLabel("Address");
        labelAddress.setFont(labelName.getFont());
    }

    private void setBoundsComponents() {
        labelName.setBounds(10, 10, 100, 30);
        nameField.setBounds(10, 35, 190, 25);
        labelEmail.setBounds(10, 65, 100, 30);
        emailField.setBounds(10, 90, 190, 25);
        labelPhone.setBounds(10, 120, 100, 30);
        phoneField.setBounds(10, 145, 190, 25);
        labelAddress.setBounds(10, 175, 100, 30);
        addressField.setBounds(10, 200, 190, 25);
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

    public String getName() {
        return nameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPhone() {
        return phoneField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public void setName(String name) {
        nameField.setText(name);
    }

    public void setEmail(String email) {
        emailField.setText(email);
    }

    public void setPhone(String phone) {
        phoneField.setText(phone);
    }

    public void setAddress(String address) {
        addressField.setText(address);
    }
}