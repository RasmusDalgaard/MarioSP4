package Services;

import DBConnector.*;
import Domain.Pizza;
import Exceptions.NoSuchPizzaException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PizzaService implements IPizzaService {
    IDBConnector dbc = new DBConnector();

    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        String sql = "";
        Pizza tmpPizza = null;

        connection = dbc.getMyConnection();
        try {
            stmt = connection.createStatement();
            sql = "SELECT * FROM Pizza";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int id = res.getInt("pizzaID");
                int price = res.getInt("price");
                String title = res.getString("title");
                String topping = res.getString("topping");
                tmpPizza = new Pizza(id, price, title, topping);
                pizzas.add(tmpPizza);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzas;
    }

    public void showPizzaMenu() {
        for (Pizza p : getAllPizzas()) {
            System.out.println(p);
        }
    }

    public Pizza getPizzaById(int id) throws NoSuchPizzaException {
        for (Pizza p : getAllPizzas()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
