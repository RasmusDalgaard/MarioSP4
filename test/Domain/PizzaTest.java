package Domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PizzaTest {

    @Test
    public void testToString() {
        Pizza p = new Pizza(1,57,"Vesuvio","tomatsauce, ost, skinke og oregano");
        assertNotNull(p.toString());
    }
}