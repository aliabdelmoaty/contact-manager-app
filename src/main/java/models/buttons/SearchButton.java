package models.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logic.SQLServer;
import models.*;

import utils.Button;
import utils.Constants;
import utils.HandleErrors;
import utils.Hints;
import utils.RoundJTextField;
import utils.Validation;

public class SearchButton extends JPanel {
    private JButton search;
    private JComboBox<String> sort;
    public Table table;
    private JLabel label;
    private JTextField textField;

    public SearchButton(Table table) {
        initializeButtons();
        setBoundsComponents();
        addComponents();
        actionButtons();
        this.table = table;
        this.setLayout(null);
        setVisible(true);

    }

    private void setBoundsComponents() {
        label.setBounds(270, 20, 90, 30);
        sort.setBounds(310, 20, 90, 30);
        textField.setBounds(450, 20, 220, 30);
        search.setBounds(700, 20, 90, 30);

    }

    private void addComponents() {
        add(sort);
        add(label);
        add(search);
        add(textField);
    }

    private void initializeButtons() {
        textField = new RoundJTextField(Hints.HINT_SEARCH, 30);
        textField.setFont(Constants.getFontForTextField());
        search = new Button("Search");
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        String country[] = { "A-Z", "Z-A" };
        sort = new JComboBox<String>(country);
        label = new JLabel("Sort");
        label.setFont(Constants.getFontForLabel());
    }

    private void actionButtons() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (Validation.validationSearch(textField.getText()) == true) {
                    try {
                        SQLServer.searchContactsByText(text, table);
                        textField.setText(Hints.HINT_SEARCH);
                    } catch (HandleErrors e1) {
                        System.out.println(e1.toString());
                        if (e1.getMessage().contains("No record found")) {
                            JOptionPane.showMessageDialog(getRootPane(),
                                    "No record found");
                            try {
                                SQLServer.getContact(table);
                            } catch (HandleErrors e2) {
                                e1.printStackTrace();
                                JOptionPane.showMessageDialog(getRootPane(), e1.getMessage());
                            }
                        } else {
                            // Handle other errors
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(getRootPane(), e1.getMessage());
                        }
                    }
                } else {
                    System.out.println("error");
                    JOptionPane.showMessageDialog(getRootPane(), "Please enter id, name or email to search");
                }
            }

        });
        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSortSelection();
            }

        });
    }

    private void handleSortSelection() {
        String selected = sort.getSelectedItem().toString();
        switch (selected) {
            case "A-Z":
                try {
                    SQLServer.sortAZ(table);
                } catch (HandleErrors e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(getRootPane(), e1);

                }
                break;
            case ("Z-A"):
                try {
                    SQLServer.sortZA(table);
                } catch (HandleErrors e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(getRootPane(), e1);
                }
                break;
            default:
                break;
        }

    }
}
