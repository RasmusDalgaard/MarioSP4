package Services;

import DBConnector.*;
import Domain.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDBService implements IOrderDBService {
    IDBConnector dbc = new DBConnector();

    public void confirmOrder(ArrayList<Order> orders) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet res = null;

        String sql = "";
        sql += "INSERT INTO CompletedOrder (currentTime,orderID,phone,pizzas,price) VALUES (?,?,?,?,?)";
        connection = dbc.getMyConnection();
        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (Order order : orders) {
                stmt.setString(1, order.getCTimeStamp());
                stmt.setInt(2, order.getOrderID());
                stmt.setString(3,order.getPhoneNr());
                stmt.setString(4, order.getAllPizzaTitles());
                stmt.setInt(5, order.getPrice());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
