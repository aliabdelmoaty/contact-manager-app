package models.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.LabelsAndTextFields;
import utils.Button;
import utils.Hints;
import utils.Images;
import utils.Validation;

public class ButtonsAdd extends JPanel {
    private JButton addButton;
    private JButton clearButton;

    private LabelsAndTextFields gTextFields;

    public ButtonsAdd(LabelsAndTextFields labelsAndTextFields) {
        initializeButtons();
        this.setLayout(null);
        this.gTextFields = labelsAndTextFields;
        setBoundsComponents();
        addComponents();
        actionButtons();
        setBackground(Color.red);
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
        addButton.setIcon(Images.addIconImage());
        addButton.setBackground(Color.black);
        addButton.setForeground(Color.white);
        clearButton = new Button("Clear");
        clearButton.setIcon(Images.clearImageIcon());
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
                                // TODO Set method Create table in Sql
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
                    // TODO: handle exception
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
  
                int option = JOptionPane.showConfirmDialog(getRootPane(), "Do you want to clear this contact ", "title",
                        JOptionPane.YES_OPTION);
                System.out.println(gTextFields.getName());
                if (option == JOptionPane.YES_OPTION) {
                    gTextFields.setName(Hints.hintName);
                    gTextFields.setEmail(Hints.hintEmail);
                    gTextFields.setPhone(Hints.hintPhone);
                    gTextFields.setAddress(Hints.hintAddress);
                }
            }
        });

    }
}
