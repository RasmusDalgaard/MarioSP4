package Exceptions;

public class InvalidPhoneNumberException extends Exception {
    public void printErrorMessage() {
        System.out.println("Please enter a phone number with 8 digits");
    }
}
