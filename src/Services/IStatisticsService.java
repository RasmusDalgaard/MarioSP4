package Services;

import Domain.CompletedOrder;

import java.util.ArrayList;
import java.util.List;

public interface IStatisticsService {
    public List getAllOrders();

    public void showStatistics();

    public int getPizzaFrequency(String target, ArrayList<String> pizzas);
}
