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

public class ButtonsAdd extends JPanel {
    private JButton addButton;
    private JButton clearButton;
    public Table table;
    private LabelsAndTextFields gTextFields;

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

    private void setBoundsComponents() {
        addButton.setBounds(15, 250, 90, 30);
        clearButton.setBounds(110, 250, 90, 30);

    }

    private void addComponents() {
        add(addButton);
        add(clearButton);
    }

    private void initializeButtons() {
        addButton = new Button("Add");
        addButton.setIcon(Constants.addIconImage());
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);
        clearButton = new Button("Clear");
        clearButton.setIcon(Constants.clearImageIcon());
        clearButton.setBackground(Color.black);
        clearButton.setForeground(Color.white);
    }

    private void actionButtons() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Validation.validationName(gTextFields.getName()) == true) {
                        if (Validation.validationEmail(gTextFields.getEmail()) == true) {
                            if (Validation.validationPhone(gTextFields.getPhone()) == true) {
                                if(Validation.validationAddress(gTextFields.getAddress())){
                                    int phone;
                                try {
                                    phone = Integer.parseInt(gTextFields.getPhone());
                                } catch (NumberFormatException NumberFormatException) {
                                    phone = 0;

                                }
                                SQLServer.insertContact(gTextFields.getName(), gTextFields.getEmail(), phone,
                                        gTextFields.getAddress());
                                JOptionPane.showMessageDialog(null, "Record added successfully", "Successful!",
                                        JOptionPane.INFORMATION_MESSAGE);
                                table.clearTable();
                                SQLServer.getContact(table);
                                table.repaint();
                                resetFields();
                                }else{
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
                    JOptionPane.showMessageDialog(null, "Failed to add record", "Error!",
                                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(getRootPane(), 
                "Do you want to clear this contact ", "Delete",JOptionPane.YES_NO_OPTION,
                        JOptionPane.YES_OPTION);
                System.out.println(gTextFields.getName());
                if (option == JOptionPane.YES_OPTION) {
                    resetFields();
                }
            }

        });

    }

    private void resetFields() {
        gTextFields.setName(Hints.HINT_NAME);
        gTextFields.setEmail(Hints.HINT_EMAIL);
        gTextFields.setPhone(Hints.HINT_PHONE);
        gTextFields.setAddress(Hints.HINT_ADDRESS);
    }
}
