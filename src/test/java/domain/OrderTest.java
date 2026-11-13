package domain;
 
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
class OrderTest {
 
    @Test

    void calculateTotalReturnsGrandTotal() {
 
        Customer customer = 
                new Customer(1, "Claudelle", "claudelle.francis@umuzi.org");
 
        Order order = 
                new Order(1, customer);
 
        Product monitor = 
                new Product(1, "Monitor", 6000);
 
        Product wirelessMouse = 
                new Product(2, "Wireless Mouse", 200);

        Product ergonomicKeyboard = 
                new Product(3, "Ergonomic Keyboard", 1000);

        order.addItem(monitor, 1);
        order.addItem(wirelessMouse, 2);
        order.addItem(ergonomicKeyboard, 1);
 
        assertEquals(7400, order.calculateTotal());

    }

}
 
 