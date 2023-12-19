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

public class ButtonEdit extends JPanel {
    private JButton editButton;
    private JButton DeleteButton;
    public Table table;

    public ButtonEdit(Table table) {
        initializeButtons();
        setBoundsComponents();
        addComponents();
        actionButtons();
        this.table = table;
        this.setLayout(null);
        setVisible(true);

    }

    private void setBoundsComponents() {
        editButton.setBounds(10, 10, 90, 30);
        DeleteButton.setBounds(200, 10, 90, 30);

    }

    private void addComponents() {
        add(DeleteButton);
        add(editButton);
    }

    private void initializeButtons() {

        editButton = new Button("Edit");
        editButton.setBackground(Color.black);
        editButton.setForeground(Color.white);

        DeleteButton = new Button("Delete");
        DeleteButton.setBackground(Color.black);
        DeleteButton.setForeground(Color.white);

    }

    private void actionButtons() {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                String name = table.getValueAt(selectedRow, 1).toString();
                String email = table.getValueAt(selectedRow, 2).toString();
                String phoneString = table.getValueAt(selectedRow, 3).toString();
                int phone = Integer.parseInt(phoneString);
                String address = table.getValueAt(selectedRow, 4).toString();
                System.out.println(id + name + email + phone + address);
                System.out.println(phoneString);
                if (Validation.validationName(name) == true) {
                    if (Validation.validationEmail(email) == true) {
                        if (Validation.validationPhone(phoneString) == true) {
                            if (Validation.validationAddress(address) == true) {
                                try {
                                    int option = JOptionPane.showConfirmDialog(getRootPane(),
                                            "Do you want to Edit this contact ",
                                            "Edit", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION) {
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

            }

        });
        DeleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());

                try {
                    int option = JOptionPane.showConfirmDialog(getRootPane(), "Do you want to delete this contact ",
                            "delete", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        SQLServer.deleteContact(id);
                        table.deleteContact(selectedRow);
                        JOptionPane.showMessageDialog(null, "Contact deleted successfully");
                    }
                } catch (HandleErrors e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, e1);
                }

            }

        });
    }
}
