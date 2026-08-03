package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderValidationTest {

    @Test
    void orderRequiresPositiveIdAndCustomer() {
        Customer customer = new Customer(1, "Claudelle", "claudelle.francis@umuzi.org");

        assertThrows(IllegalArgumentException.class, () -> new Order(0, customer));
        assertThrows(NullPointerException.class, () -> new Order(1, null));
    }
}
