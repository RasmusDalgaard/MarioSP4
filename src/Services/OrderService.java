package Services;

import Domain.Order;
import Domain.Pizza;
import Exceptions.InvalidPhoneNumberException;
import Exceptions.NoSuchPizzaException;
import UI.IMenu;
import UI.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService implements IOrderService {
    List<Pizza> pizzas = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    IPizzaService ps = new PizzaService();

    public void createOrder() {
        Order order = new Order();
        Pizza pizza = null;
        IMenu iMenu = new Menu();
        int pizzaId = 0;
        String phoneNr = "";
        while (phoneNr.length() != 8) {
            try {
                phoneNr = iMenu.addPhoneNrToOrder();
                order.setPhoneNr(phoneNr);
            } catch (InvalidPhoneNumberException e) {
                e.printErrorMessage();
            }
        }
        List<Pizza> allPizzas = ps.getAllPizzas();
        while (pizzaId != 99) {
            try {
                pizzaId = iMenu.addPizzaToOrder();
                if (pizzaId != 99) {
                    pizza = ps.getPizzaById(pizzaId);
                    order.getPizzas().add(pizza);
                }
            } catch (NoSuchPizzaException e) {
                e.printErrorMessage();
            }
        }
        orders.add(order);
    }

    public void showActiveOrders() {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public void clearOrders() {
        orders.clear();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

}
