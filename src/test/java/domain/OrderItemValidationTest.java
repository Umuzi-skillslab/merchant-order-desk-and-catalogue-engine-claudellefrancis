package domain;
 
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.assertThrows;
 
class OrderItemValidationTest {
 
    @Test
    void quantityMustBeGreaterThanZero() {
 
        Product monitor =
                new Product(1, "Monitor", 6000);

        Product wirelessMouse =
                new Product(2, "Wireless Mouse", 200);

        Product ergonomicKeyboard =
                new Product(3, "Ergonomic Keyboard", 1000);
 
        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem(monitor, 0)
        );
    }
}