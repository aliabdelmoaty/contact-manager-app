package utils;

import javax.swing.*;
import java.awt.Image;
import java.awt.Font;

public abstract class Constants {

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
    public static ImageIcon editIconImage() {
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\edit.png");
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
        public static ImageIcon saveIconImage() {
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\save.png");
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }    public static ImageIcon removeIconImage() {
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\remove.png");
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    public static Font fontTable() {
        return new Font("Verdana", Font.BOLD, 14);
    }

    public static Font fontTextFiled() {
        return new Font("Baskerville", Font.BOLD, 11);
    }

    public static Font fontLabel() {
        return new Font("Verdana", Font.BOLD, 14);
    }
}
