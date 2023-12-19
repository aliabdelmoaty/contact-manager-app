package utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

// Custom JTextField with rounded corners and hint text
public class RoundJTextField extends JTextField {
    // Shape used for hit detection (checking if a point is inside the rounded rectangle)
    private Shape shape;

    // Constructor for RoundJTextField
    public RoundJTextField(String hint, int columns) {
        // Call the superclass constructor with the hint and columns
        super(hint, columns);

        // Make the background of the text field transparent
        setOpaque(false);

        // Set the text color to gray
        setForeground(Color.GRAY);

        // Set the font to Arial, bold, with size 12
        setFont(Constants.getFontForTextField());

        // Add a focus listener to handle focus gained and lost events
        addFocusListener(new FocusListener() {
            // This method is called when the text field gains focus
            @Override
            public void focusGained(FocusEvent e) {
                // If the text is the same as the hint, clear the text and set the color to gray
                if (getText().equals(hint)) {
                    setText("");
                    setForeground(Color.GRAY);
                }
            }

            // This method is called when the text field loses focus
            @Override
            public void focusLost(FocusEvent e) {
                // If the text field is empty, set the text to the hint and the color to gray
                if (getText().isEmpty()) {
                    setText(hint);
                    setForeground(Color.GRAY);
                }
            }
        });
    }

    // This method is called to paint the component
    protected void paintComponent(Graphics g) {
        // Set the color to the background color of the text field
        g.setColor(Color.white);

        // Fill a rounded rectangle that fits the text field
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);

        // Call the superclass's paintComponent method to do the default painting
        super.paintComponent(g);
    }

    // This method is called to paint the border of the component
    protected void paintBorder(Graphics g) {
        // Set the color to black for the border
        g.setColor(Color.BLACK);

        // Draw a rounded rectangle as the border
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    // This method checks if a point (x, y) is inside the rounded rectangle
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
