package Services;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTest {

    @org.junit.jupiter.api.Test
    void getAllPizzas() {
        IPizzaService ps = new PizzaService();
        assertNotNull(ps.getAllPizzas());
    }
}