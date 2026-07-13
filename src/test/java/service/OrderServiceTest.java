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

        Product product1 = new Product(1, "Monitor", 6000);
        service.addProductsToOrder(order, product1, 1);

        Product product2 = new Product(2, "Wireless Mouse", 200);
        service.addProductsToOrder(order, product2, 2);

        Product product3 = new Product(3, "Ergonomic Keyboard", 1000);
        service.addProductsToOrder(order, product3, 1);

        assertEquals(3, order.getItems().size());
        assertEquals(7400, order.calculateTotal());

    }
}
