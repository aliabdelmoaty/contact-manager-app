
package utils;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class LinePanel extends JPanel {
    public LinePanel() {
        setLayout(null);
        setBackground(Color.red);
        setBounds(210, 0, 10, 600);

        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);

        g.drawLine(10, 0, 10, 600);
    }
}
