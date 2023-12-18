package main.java;

import javax.swing.JFrame;

import models.LabelsAndTextFields;
import models.Table;
import models.buttons.ButtonsAdd;

public class Project extends JFrame {
    private LabelsAndTextFields labelsAndTextFields;
    private ButtonsAdd buttons;
    private Table table;

    public Project(LabelsAndTextFields labelsAndTextFields, ButtonsAdd buttons) {
        this.labelsAndTextFields = labelsAndTextFields; // Use the provided instance
        this.buttons = buttons; // Use the provided instance
        table = new Table();
        setTitle("Project");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        labelsAndTextFields.setBounds(0, 0, 210, 240);
        buttons.setBounds(0, 0, 210, 280);
        table.setBounds(230, 0, 400, 600);
        this.add(labelsAndTextFields);
        this.add(buttons);
        this.add(table);
        setVisible(true);
    }

    public static void main(String[] args) {
        LabelsAndTextFields labelsAndTextFields = new LabelsAndTextFields();
        ButtonsAdd buttons = new ButtonsAdd(labelsAndTextFields);
        new Project(labelsAndTextFields, buttons);
    }

}
