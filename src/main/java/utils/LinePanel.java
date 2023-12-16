
package utils;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class LinePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);

        g.drawLine(210, 0, 210, 600);
    }
}
