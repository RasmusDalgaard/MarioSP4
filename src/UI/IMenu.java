package UI;

import Exceptions.InvalidPhoneNumberException;
import Exceptions.NoSuchPizzaException;

public interface IMenu {
    public void showMainMenu();

    public void showConfirmOrderUI();

    public void newLine();

    public void exit();

    public int addPizzaToOrder() throws NoSuchPizzaException;

    public String addPhoneNrToOrder() throws InvalidPhoneNumberException;
}
