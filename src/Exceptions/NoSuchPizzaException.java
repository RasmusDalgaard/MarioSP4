package Exceptions;

public class NoSuchPizzaException extends Exception{
    public void printErrorMessage() {
        System.out.println("There is no pizza with this number");
    }
}
