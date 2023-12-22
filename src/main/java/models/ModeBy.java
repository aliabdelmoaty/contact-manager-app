package models;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Constants;
import java.awt.Desktop;

public class ModeBy extends JPanel {

    JButton linkedIn; // Button for LinkedIn
    JButton github; // Button for GitHub
    JLabel dev1; // Label for developer 1
    JLabel dev2; // Label for developer 2
    JLabel modeBy; // Label for "Mode By"

    public ModeBy() {
        initializeButtons(); // Initialize UI components
        setBoundsComponents(); // Set the bounds (positions and sizes) of UI components
        addComponents(); // Add UI components to the panel
        // setBackground(Color.blue);
        actionButtons(); // Set up action listeners for buttons
        this.setLayout(null); // Set the layout to null for manual component positioning
        setVisible(true); // Set the panel as visible
    }

    private void initializeButtons() {
        linkedIn = new JButton(Constants.linkedinIconImage()); // Create LinkedIn button with icon
        github = new JButton(Constants.githubIconImage()); // Create GitHub button with icon
        modeBy = new JLabel("Mode By"); // Create label for "Mode By"
        modeBy.setFont(Constants.getFontForTable()); // Set font for "Mode By" label
        dev1 = new JLabel("Ali Mohamed"); // Create label for developer 1
        dev1.setFont(Constants.getFontForLabel()); // Set font for developer 1 label
        dev2 = new JLabel("<html>Youssef Mahmoud<br/>Khaled Ayman<br/>Waheed Ahmed<br/>Mazen Ahmed</html>"); // Create label for developer 2
        dev2.setFont(Constants.getFontForLabel()); // Set font for developer 2 label

    }

    private void setBoundsComponents() {
        modeBy.setBounds(15, 0, 120, 20); // Set bounds for "Mode By" label
        dev1.setBounds(15, 21, 110, 20); // Set bounds for developer 1 label
        linkedIn.setBounds(130, 21, 23, 23); // Set bounds for LinkedIn button
        github.setBounds(160, 21, 23, 23); // Set bounds for GitHub button
        dev2.setBounds(15, 15, 150, 130); // Set bounds for developer 2 label

    }

    private void addComponents() {
        add(modeBy); // Add "Mode By" label to the panel
        add(dev1); // Add developer 1 label to the panel
        add(dev2); // Add developer 2 label to the panel
        add(linkedIn); // Add LinkedIn button to the panel
        add(github); // Add GitHub button to the panel

    }

    private void actionButtons() {
        linkedIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebLink("www.linkedin.com/in/ali-abdelmoaty"); // Open LinkedIn profile in a web browser
            }
        });
         github.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebLink("https://github.com/aliabdelmoaty"); // Open GitHub profile in a web browser
            }
        });
    }

    private void openWebLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url)); // Open the specified URL in a web browser
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
}
