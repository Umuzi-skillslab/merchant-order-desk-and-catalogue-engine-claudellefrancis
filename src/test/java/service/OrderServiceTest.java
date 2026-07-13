package service;

import domain.Customer;
import domain.Order;
import domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void createOrderAddItemsAndCheckout() {
        Customer customer = new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");
        OrderService service = new OrderService();
        Order order = service.createOrder(1, customer);

        Product monitor = new Product(1, "Monitor", 6000);
        service.addProductsToOrder(order, monitor, 1);

        Product wirelessMouse = new Product(2, "Wireless Mouse", 200);
        service.addProductsToOrder(order, wirelessMouse, 2);

        Product ergonomicKeyboard = new Product(3, "Ergonomic Keyboard", 1000);
        service.addProductsToOrder(order, ergonomicKeyboard, 1);

        assertEquals(3, order.getItems().size());
        assertEquals(7400, order.calculateTotal());

    }
}
