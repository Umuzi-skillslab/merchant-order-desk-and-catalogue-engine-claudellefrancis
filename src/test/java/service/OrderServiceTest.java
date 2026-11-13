package service;

import com.PayNestApplication.domain.Customer;
import com.PayNestApplication.domain.Order;
import com.PayNestApplication.domain.Product;
import com.PayNestApplication.service.OrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void createOrderAddItemsAndCheckout() {
        Customer customer = new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");
        OrderService service = new OrderService();
        Order order = service.createOrder(1, customer);

        Product monitor = new Product(1, "Monitor", 5000);
        service.addProductToOrder(order, monitor, 1);

        Product iPad = new Product(3, "iPad", 15000);
        service.addProductToOrder(order, iPad, 4);

        Product keyboard = new Product(3, "Keyboard", 500);
        service.addProductToOrder(order, keyboard, 3);

        assertEquals(3, order.getItems().size());
        assertEquals(66500, order.calculateTotal());

    }
}
