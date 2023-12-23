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
        // Load and scale the 'Add' icon image
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
        // Load and scale the 'Clear' icon image
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\clear.png");
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    /**
     * Returns an ImageIcon for the 'Edit' action.
     *
     * @return ImageIcon for 'Edit' action
     */
    public static ImageIcon linkedinIconImage() {
        // Load and scale the 'Edit' icon image
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\linkedin.png");
        Image image = icon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    /**
     * Returns an ImageIcon for the 'Save' action.
     *
     * @return ImageIcon for 'Save' action
     */
    public static ImageIcon githubIconImage() {
        // Load and scale the 'Save' icon image
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\github.png");
        Image image = icon.getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    /**
     * Returns an ImageIcon for the 'Remove' action.
     *
     * @return ImageIcon for 'Remove' action
     */
    public static ImageIcon removeIconImage() {
        // Load and scale the 'Remove' icon image
        ImageIcon icon = new ImageIcon("src\\main\\resources\\icons\\remove.png");
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    /**
     * Returns a Font for table components.
     *
     * @return Font for table components
     */
    public static Font getFontForTable() {
        return new Font("Verdana", Font.BOLD, 14);
    }

    /**
     * Returns a Font for text fields.
     *
     * @return Font for text fields
     */
    public static Font getFontForTextField() {
        return new Font("Baskerville", Font.BOLD, 11);
    }

    /**
     * Returns a Font for labels.
     *
     * @return Font for labels
     */
    public static Font getFontForLabel() {
        return new Font("Verdana", Font.BOLD, 14);
    }

    // SQL queries and statements
    public static final String CREATE_CONTACT = "CREATE TABLE IF NOT EXISTS ali (id INT AUTO_INCREMENT PRIMARY KEY, name TEXT NOT NULL, email TEXT NOT NULL, phone INTEGER NOT NULL, address TEXT NOT NULL, time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
    public static final String INSERT_CONTACT = "INSERT INTO contacts(name, email, phone, address) VALUES (?, ?, ?, ?)";
    public static final String DELETE_CONTACT = "DELETE FROM contacts WHERE id = ?";
    public static final String GET_CONTACT = "SELECT * FROM contacts";
    public static final String SORT_AZ = "SELECT * FROM contacts ORDER BY name ASC";
    public static final String SORT_ZA = "SELECT * FROM contacts ORDER BY name DESC";
    public static final String SEARCH_TEXT = "SELECT * FROM contacts WHERE id LIKE ? OR name LIKE ? OR email LIKE ?";
    public static final String EDIT_CONTACT = "UPDATE contacts SET name = ?, email = ?, phone = ?, address = ? WHERE id = ?";
}
