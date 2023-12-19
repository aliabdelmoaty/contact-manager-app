package main.java;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.SQLServer;
import models.LabelsAndTextFields;
import models.Table;
import models.buttons.SearchButton;
import models.buttons.ButtonEdit;
import models.buttons.ButtonsAdd;

public class Project extends JFrame {

    public Project(LabelsAndTextFields labelsAndTextFields, ButtonsAdd buttonsAdd, Table table,
            ButtonEdit buttonEdit, SearchButton searchButton) {

        setTitle("Project");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        labelsAndTextFields.setBounds(0, 0, 210, 240);
        buttonsAdd.setBounds(0, 0, 210, 280);

        table.setBounds(230, 80, 600, 500);
        buttonEdit.setBounds(300, 500, 300, 200);
        searchButton.setBounds(300, 100, 300, 100);

        this.add(labelsAndTextFields);
        this.add(buttonsAdd);
        this.add(buttonEdit);

        this.add(table);
        this.add(searchButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        Table table = new Table();
        LabelsAndTextFields labelsAndTextFields = new LabelsAndTextFields();
        ButtonsAdd buttons = new ButtonsAdd(labelsAndTextFields, table);
        ButtonEdit buttonEdit = new ButtonEdit(table);
        SearchButton searchButton = new SearchButton(table);
        // Show loading dialog
        LoadingDialog loadingDialog = new LoadingDialog();
        loadingDialog.setVisible(true);

        try {
            SQLServer.getContact(table);
            new Project(labelsAndTextFields, buttons, table, buttonEdit, searchButton);
        } catch (Exception e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error getting contacts. Please check your server.", "Error!",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            loadingDialog.setVisible(false);
            loadingDialog.dispose();
        }
    }

    static class LoadingDialog extends JFrame {
        public LoadingDialog() {
            JLabel label = new JLabel();
            label.setText("Loading....");
            JPanel panel = new JPanel();
            panel.add(label);
            this.add(panel);
            setResizable(false);
            setUndecorated(true);
            setSize(150, 50);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
