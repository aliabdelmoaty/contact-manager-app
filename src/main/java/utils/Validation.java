package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Validation {

    public static boolean validationName(String name) {
        // Validate name (at least 2 characters)
        return name.length() >= 2 && name.matches("[a-zA-Z]+");
    }

    public static boolean validationEmail(String email) {
        // Validate email format
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return email.length() >= 2 && matcher.matches();
    }

    public static boolean validationPhone(String phone) {
        // Validate phone (11 digits starting with "01" for Egypt)
        return phone.length() == 11 && phone.matches("01[0-9]{9}");
    }
}
