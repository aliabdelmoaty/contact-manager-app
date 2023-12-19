package utils;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

// Custom Canvas representing a vertical line
public class LinePanel extends Canvas {

    // Override paint to draw the vertical line
    @Override
    public void paint(Graphics g) {
        // Set the background color of the canvas to black
        setBackground(Color.black);

        // Set the foreground color (line color) to red
        setForeground(Color.RED);

        // Draw a vertical line from (250, 0) to (251, 600)
        g.drawLine(250, 0, 251, 600);
    }
}
