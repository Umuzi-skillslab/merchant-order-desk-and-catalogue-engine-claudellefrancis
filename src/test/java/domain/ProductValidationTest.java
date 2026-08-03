package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductValidationTest {

    @Test
    void productPriceMustBeNonNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Product(1, "Monitor", -1));
    }
}
