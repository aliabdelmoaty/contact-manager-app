package models.buttons;

import java.awt.Color;

import javax.swing.JButton;

import utils.Button;
import utils.Images;

public class ButtonEdit extends JButton{
    private JButton editButton;
    private JButton saveButton;
    private JButton cancelButton;


    private void setBoundsComponents() {
        saveButton.setBounds(15, 250, 90, 30);
        cancelButton.setBounds(110, 250, 90, 30);
        editButton.setBounds(250, 10, 90, 30);

    }
    
    private void addComponents() {
        add(saveButton);
        add(cancelButton);
        add(editButton);
    }
    private void initializeButtons() {


        editButton = new Button("Edit");
        // editButton.setIcon(Images.editIconImage());
        editButton.setBackground(Color.black);
        editButton.setForeground(Color.white);

        saveButton = new Button("Save");
        // saveButton.setIcon(Images.saveIconImage());
        saveButton.setBackground(Color.black);
        saveButton.setForeground(Color.white);

        cancelButton = new Button("Cancel");
        cancelButton.setBackground(Color.black);
        cancelButton.setForeground(Color.white);

    }
}
