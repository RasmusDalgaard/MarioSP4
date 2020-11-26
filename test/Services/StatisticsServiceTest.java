package Services;

import Domain.CompletedOrder;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class StatisticsServiceTest {
    IStatisticsService ss = new StatisticsService();

    /*
     public CompletedOrder(String timestamp, int id, String phoneNr, List<String> pizzas, int price) {
        this.timestamp = timestamp;
        this.id = id;
        this.phoneNr = phoneNr;
        this.pizzas = pizzas;
        this.price = price;
    }
     */

    @Test
    public void getTurnover() {
        int expected = 1240;
        int actual = ss.getTurnover();
        assertEquals(expected,actual);
    }
}