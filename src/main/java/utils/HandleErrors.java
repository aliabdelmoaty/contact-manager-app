package utils;

// Custom exception class to handle errors in the application
public class HandleErrors extends Exception {

    // Constructor that takes a message describing the error
    public HandleErrors(String message) {
        super(message);
    }
}
