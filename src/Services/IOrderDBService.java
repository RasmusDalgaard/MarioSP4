package Services;

import Domain.Order;

import java.util.ArrayList;

public interface IOrderDBService {
    public void confirmOrder(ArrayList<Order> orders);
}
