package com.paynestsystem.service;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    @Test
    void createOrderAddItemsAndCheckout() {
        Customer customer =
                new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");

        OrderService service = new OrderService();

        Order order = service.createOrder(1, customer);

        Product monitor = new Product(1, "Monitor", 6000);
        Product wirelessMouse = new Product(2, "Wireless Mouse", 200);

        service.addProductsToOrder(order, monitor, 1);
        service.addProductsToOrder(order, wirelessMouse, 2);
        assertEquals(2, order.getItems().size());
        assertEquals(6400.0, order.calculateTotal(), 0.0001);
    }
}