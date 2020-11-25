package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void getPrice() {
        Order order = new Order();
        Pizza pizza1 = new Pizza(1, 57, "Vesuvio", "tomatsauce, ost, skinke og oregano");
        Pizza pizza2 = new Pizza(2, 53, "Amerikaner", "tomatsauce, ost, oksefars og oregano");
        Pizza pizza3 = new Pizza(3, 57, "Cacciatore", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano");
        Pizza pizza4 = new Pizza(4, 63, "Carbona", "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano");
        Pizza pizza5 = new Pizza(5, 63, "Dennis", "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano");
        Pizza pizza6 = new Pizza(6, 57, "Bertil", "tomatsauce, ost, bacon og oregano");
        Pizza pizza7 = new Pizza(7, 61, "Silvia", "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano");
        Pizza pizza8 = new Pizza(8, 61, "Victoria", "tomatsauce, ost, skinke, ananas, champignon, løg og oregano");
        Pizza pizza9 = new Pizza(9, 61, "Toronfo", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano");
        Pizza pizza10 = new Pizza(10, 61, "Capricciosa", "tomatsauce, ost, skinke, champignon og oregano");
        Pizza pizza11 = new Pizza(11, 61, "Hawaii", "tomatsauce, ost, skinke, ananas og oregano");
        Pizza pizza12 = new Pizza(12,69,"Rasmus","gorgonzola, parmesan, gedeost og mozzarella");

        order.addPizza(pizza1);
        order.addPizza(pizza2);
        order.addPizza(pizza3);
        order.addPizza(pizza4);
        order.addPizza(pizza5);
        order.addPizza(pizza6);
        order.addPizza(pizza7);
        order.addPizza(pizza8);
        order.addPizza(pizza9);
        order.addPizza(pizza10);
        order.addPizza(pizza11);
        order.addPizza(pizza12);
        int expected = 724;
        int actual = order.getPrice();
        assertEquals(expected, actual);
    }
}