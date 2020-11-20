package Services;

import DBConnector.*;
import Domain.CompletedOrder;
import Domain.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StatisticsService implements IStatisticsService {
    IDBConnector dbc = new DBConnector();
    IPizzaService ps = new PizzaService();
    HashMap<String, Integer> pizzaFrequency = new HashMap<String, Integer>();

    public List<CompletedOrder> getAllOrders() {
        List<CompletedOrder> completedOrders = new ArrayList<>();
        List<String> pizzasAsList = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";
        CompletedOrder tmpCompletedOrder = null;


        connection = dbc.getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM CompletedOrder";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                String timestamp = res.getString("currentTime");
                int id = res.getInt("orderID");
                String phoneNr = res.getString("phone");
                String pizzas = res.getString("pizzas");
                int price = res.getInt("price");
                String[] p;
                String delimiter = ",";
                p = pizzas.split(delimiter);
                pizzasAsList = Arrays.asList(p);
                tmpCompletedOrder = new CompletedOrder(timestamp, id, phoneNr, pizzasAsList, price);
                completedOrders.add(tmpCompletedOrder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return completedOrders;
    }

    public void showStatistics() {
        ArrayList<String> pizzaCount = new ArrayList<>();
        List<CompletedOrder> completedOrders = getAllOrders();
        for (CompletedOrder o : completedOrders) {
            for (String p : o.getPizzas()) {
                pizzaCount.add(p);
            }
        }
        for (Pizza p : ps.getAllPizzas()) {
            pizzaFrequency.put(p.getTitle(), getPizzaFrequency(p.getTitle(), pizzaCount));
            System.out.println(p.getTitle() + ": " + getPizzaFrequency(p.getTitle(), pizzaCount));
        }
        System.out.println("\nTotal earned: " + getTurnover() + ",-");
    }

    public int getTurnover() {
        int price = 0;
        for (CompletedOrder o : getAllOrders()) {
            price += o.getPrice();
        }
        return price;
    }

    public int getPizzaFrequency(String target, ArrayList<String> pizzas) {
        int counter = 0;
        for (String p : pizzas) {
            if (p.equals(target)) {
                counter = counter + 1;
            }
        }
        return counter;
    }

}

