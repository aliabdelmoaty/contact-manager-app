package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundJTextField extends JTextField {
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
        setFont(new Font("Arial", Font.BOLD, 12));

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
        g.setColor(getBackground());

        // Fill a rounded rectangle that fits the text field
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);

        // Call the superclass's paintComponent method to do the default painting
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}



