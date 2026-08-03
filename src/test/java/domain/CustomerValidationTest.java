package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerValidationTest {

    @Test
    void customerRequiresNonBlankNameAndEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Customer(1, "", "claudelle.francis@umuzi.org"));
        assertThrows(IllegalArgumentException.class, () -> new Customer(1, "Claudelle", "   "));
    }
}
