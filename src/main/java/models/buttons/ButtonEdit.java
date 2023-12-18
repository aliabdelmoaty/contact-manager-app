package models.buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.Button;

public class ButtonEdit extends JPanel {
    private JButton editButton;
    private JButton saveButton;
    private JButton cancelButton;

    public ButtonEdit() {
        initializeButtons();
        setBoundsComponents();
        addComponents();
        this.setLayout(null);
        setVisible(true);

    }

    private void setBoundsComponents() {
        editButton.setBounds(250, 510, 90, 30);
        saveButton.setBounds(370, 510, 90, 30);
        cancelButton.setBounds(500, 510, 90, 30);

    }

    private void addComponents() {
        add(saveButton);
        add(cancelButton);
        add(editButton);
    }

    private void initializeButtons() {

        editButton = new Button("Edit");
        editButton.setBackground(Color.black);
        editButton.setForeground(Color.white);
        saveButton = new Button("Save");
        saveButton.setBackground(Color.black);
        saveButton.setForeground(Color.white);

        cancelButton = new Button("Cancel");
        cancelButton.setBackground(Color.black);
        cancelButton.setForeground(Color.white);

    }

    private void actionButtons(){
        // Action for the Edit button
        // editButton.addActionListener(e -> {
        //     // Get the selected row index
        //     int i = table.getSelectedRow();
        //     if (i >= 0) {
        //         // Remove the row from the table
        //         model.removeRow(i);
        //         System.out.println("Row deleted successfully");
        //     } else {
        //         System.out.println("Delete Error");
        //     }
        // });
        // Action for the Save button
      

        editButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });
    }
}
