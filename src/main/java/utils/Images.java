package utils;

import javax.swing.*;
import java.awt.Image;

public abstract class Images {

    /**
     * Returns an ImageIcon for the 'Add' action.
     *
     * @return ImageIcon for 'Add' action
     */
    public static ImageIcon addIconImage() {
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\add.png");
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    /**
     * Returns an ImageIcon for the 'Clear' action.
     *
     * @return ImageIcon for 'Clear' action
     */
    public static ImageIcon clearImageIcon() {
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\clear.png");
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
