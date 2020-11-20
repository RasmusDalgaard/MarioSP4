package Controller;

import DBConnector.*;
import Services.*;
import UI.*;

import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    IDBConnector dbc = new DBConnector();
    IPizzaService ps = new PizzaService();
    IOrderService os = new OrderService();
    IOrderDBService ods = new OrderDBService();
    IStatisticsService ss = new StatisticsService();
    IMenu menu = new Menu();
    int choice = 0;

    public void runProgram() {
        while (choice != 9) {
            dbc.getMyConnection();
            menu.showMainMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ps.showPizzaMenu();
                    menu.newLine();
                    break;
                case 2:
                    os.createOrder();
                    break;
                case 3:
                    os.showActiveOrders();
                    menu.newLine();
                    break;
                case 4:
                    ods.confirmOrder(os.getOrders());
                    os.clearOrders();
                    menu.showConfirmOrderUI();
                    break;
                case 5:
                    ss.showStatistics();
                    break;
                case 9:
                    menu.exit();
                    break;
                default:
                    choice = 9;
                    menu.exit();
                    break;
            }
        }
    }
}
