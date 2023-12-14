package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class RoundedBorder extends JButton {
    // Default values
    private static final Color DEFAULT_BG_COLOR = new Color(102, 204, 255);
    private static final Color DEFAULT_TEXT_COLOR = Color.WHITE;
    private static final int DEFAULT_RADIUS = 20;
    private static final Color SHADOW_COLOR = Color.gray;
    private static final int SHADOW_SIZE = 20;

    // Flag to track whether the button is pressed or not
    private boolean isPressed = false;

    // Constructor taking the text
    public RoundedBorder(String text) {
        this(text, DEFAULT_BG_COLOR, DEFAULT_TEXT_COLOR);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle the flag when the button is clicked
                isPressed = !isPressed;
                repaint(); // Repaint the button to apply changes

                if (isPressed) {
                    Timer timer = new Timer(80, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            isPressed = false;
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    timer.start();
                }
            }
        });
    }

    // Constructor taking the text and the color of the button
    public RoundedBorder(String text, Color bgColor, Color textColor) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 12));
        setContentAreaFilled(true);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setBackground(bgColor);
        setForeground(textColor);
    }

    // To change the shape of the button
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Draw shadow only if the button is not pressed
        if (!isPressed) {
            g2.setColor(SHADOW_COLOR);
            g2.fillRoundRect(SHADOW_SIZE, SHADOW_SIZE, width - SHADOW_SIZE, height - SHADOW_SIZE, DEFAULT_RADIUS,
                    DEFAULT_RADIUS);
        }

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, DEFAULT_RADIUS,
                DEFAULT_RADIUS);

        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        if (!isPressed) {
            g2.fillRoundRect(0, 0, width - SHADOW_SIZE, height - SHADOW_SIZE, DEFAULT_RADIUS, DEFAULT_RADIUS);
        }

        setContentAreaFilled(false);

        super.paintComponent(g);
    }

    // To create a border if you want
    @Override
    protected void paintBorder(Graphics g) {
        // You can add border painting logic here if needed
    }
}
