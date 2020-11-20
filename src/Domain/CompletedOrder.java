package Domain;

import Services.*;

import java.util.List;

public class CompletedOrder {
    private String timestamp;
    private int id;
    private String phoneNr;
    private List<String> pizzas;
    private int price;

    IPizzaService ps = new PizzaService();
    IStatisticsService ss = new StatisticsService();

    public CompletedOrder(String timestamp, int id, String phoneNr, List<String> pizzas, int price) {
        this.timestamp = timestamp;
        this.id = id;
        this.phoneNr = phoneNr;
        this.pizzas = pizzas;
        this.price = price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public List<String> getPizzas() {
        return pizzas;
    }

    public int getPrice() {
        return price;
    }
}
