package domain;
 
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
class OrderItemTest {
 
    @Test
    void calculateTotalReturnsCorrectSubtotal() {
 
        Product product = new Product(1, "Monitor", 6000);
 
        OrderItem item = new OrderItem(product, 1);
 
        assertEquals(6000, item.calculateTotal());
    }
}
 