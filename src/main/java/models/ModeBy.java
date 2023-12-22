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

    JButton linkedIn;
    JButton github;
    JLabel dev1;
    JLabel dev2;
    JLabel modeBy;

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
        linkedIn = new JButton(Constants.linkedinIconImage());
        github = new JButton(Constants.githubIconImage());
        modeBy = new JLabel("Mode By");
        modeBy.setFont(Constants.getFontForTable());
        dev1 = new JLabel("Ali Mohamed");
        dev1.setFont(Constants.getFontForLabel());
        dev2 = new JLabel("<html>Youssef Mahmoud<br/>Khaled Ayman<br/>Waheed Ahmed<br/>Mazen Ahmed</html>");
        dev2.setFont(Constants.getFontForLabel());

    }

    private void setBoundsComponents() {
        modeBy.setBounds(15, 0, 120, 20);
        dev1.setBounds(15, 21, 110, 20);
        linkedIn.setBounds(130, 21, 23, 23);
        github.setBounds(160, 21, 23, 23);
        dev2.setBounds(15, 15, 150, 130);

    }

    private void addComponents() {
        add(modeBy);
        add(dev1);
        add(dev2);
        add(linkedIn);
        add(github);

    }

    private void actionButtons() {
        linkedIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebLink("www.linkedin.com/in/ali-abdelmoaty10");
            }
        });
         github.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebLink("https://github.com/aliabdelmoaty");
            }
        });
    }

    private void openWebLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
}
