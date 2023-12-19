package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Abstract class providing validation methods for various input fields
abstract public class Validation {

    /**
     * Validates the name input.
     * 
     * @param name The name to be validated.
     * @return True if the name is valid, false otherwise.
     */
    public static boolean validationName(String name) {
        if (name.equals(Hints.HINT_NAME)) {
            return false;
        }
        // Validate name (at least 2 characters, allows letters and spaces)
        return name.length() >= 2 && name.matches("[a-zA-Z]+[a-zA-Z ]*");
    }

    /**
     * Validates the address input.
     * 
     * @param address The address to be validated.
     * @return True if the address is valid, false otherwise.
     */
    public static boolean validationAddress(String address) {
        if (address.equals(Hints.HINT_ADDRESS)) {
            return false;
        }
        // Validate Address (at least 2 characters, allows letters and spaces)
        return address.length() >= 2 && address.matches("[a-zA-Z]+[a-zA-Z ]*");
    }

    /**
     * Validates the search input.
     * 
     * @param search The search string to be validated.
     * @return True if the search is valid, false otherwise.
     */
    public static boolean validationSearch(String search) {
        if (search == null || search.isEmpty() || search.equals(Hints.HINT_EMAIL)) {
            return false;
        } else {
            // Validate search (at least 2 characters, allows letters and spaces)
            return search.length() >= 1 && search.matches("^[a-zA-Z0-9\\s]+$");
        }
    }

    /**
     * Validates the email input.
     * 
     * @param email The email to be validated.
     * @return True if the email is valid, false otherwise.
     */
    public static boolean validationEmail(String email) {
        if (email.equals(Hints.HINT_EMAIL)) {
            return false;
        }
        // Validate email format using a regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return email.length() >= 2 && matcher.matches();
    }

    /**
     * Validates the phone input.
     * 
     * @param phone The phone number to be validated.
     * @return True if the phone number is valid, false otherwise.
     */
    public static boolean validationPhone(String phone) {
        if (phone.equals(Hints.HINT_PHONE)) {
            return false;
        }
        // Validate phone (11 digits starting with "01" for Egypt)
        return phone.matches("[01][1250][0-9]{7,9}");
    }
}
