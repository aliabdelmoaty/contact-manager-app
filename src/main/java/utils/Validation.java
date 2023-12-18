package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Validation {

    public static boolean validationName(String name) {
        if(name.equals(Hints.HINT_NAME)){
            return false;
        }
        // Validate name (at least 2 characters)
        return name.length() >= 2 && name.matches("[a-zA-Z]+[a-zA-Z ]*");

    }
        public static boolean validationAddress(String address) {
            if(address.equals(Hints.HINT_ADDRESS)){
            return false;
        }
        // Validate Address (at least 2 characters)
        return address.length() >= 2 && address.matches("[a-zA-Z]+[a-zA-Z ]*");

    }

    public static boolean validationEmail(String email) {
        if(email.equals(Hints.HINT_EMAIL)){
            return false;
        }
        // Validate email format
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return email.length() >= 2 && matcher.matches();
    }

    public static boolean validationPhone(String phone) {
        if(phone.equals(Hints.HINT_PHONE)){
            return false;
        }
        // Validate phone (11 digits starting with "01" for Egypt)
         return phone.matches("[01][1250][0-9]{7,9}");

    }
}
