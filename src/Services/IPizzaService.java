package Services;

import Domain.Pizza;
import Exceptions.NoSuchPizzaException;

import java.util.List;

public interface IPizzaService {
    public List<Pizza> getAllPizzas();
    public Pizza getPizzaById(int id) throws NoSuchPizzaException;
    public void showPizzaMenu();
}
