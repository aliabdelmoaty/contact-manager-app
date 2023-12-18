package main.java;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.SQLServer;
import models.LabelsAndTextFields;
import models.Table;
import models.buttons.ButtonEdit;
import models.buttons.ButtonsAdd;

public class Project extends JFrame {
    private ButtonEdit buttonEdit;

    public Project(LabelsAndTextFields labelsAndTextFields, ButtonsAdd buttonsAdd, Table table,ButtonEdit buttonEdit) {

        setTitle("Project");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        labelsAndTextFields.setBounds(0, 0, 210, 240);
        buttonsAdd.setBounds(0, 0, 210, 280);

        table.setBounds(230, 100, 600, 500);
        buttonEdit.setBounds(300, 600, 300, 200);

        this.add(labelsAndTextFields);
        this.add(buttonsAdd);
        this.add(table);
        this.add(buttonEdit);

        setVisible(true);
    }

    public static void main(String[] args) {
        Table table = new Table();
        LabelsAndTextFields labelsAndTextFields = new LabelsAndTextFields();
        ButtonsAdd buttons = new ButtonsAdd(labelsAndTextFields, table);
        ButtonEdit buttonEdit =new ButtonEdit();
        // Show loading dialog
        LoadingDialog loadingDialog = new LoadingDialog();
        loadingDialog.setVisible(true);

        try {
            SQLServer.getContact(table);
            new Project(labelsAndTextFields, buttons, table, buttonEdit);
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
