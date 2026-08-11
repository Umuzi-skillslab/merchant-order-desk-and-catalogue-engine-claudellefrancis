package com.paynetsystem.service;

import com.paynetsystem.domain.Customer;
import com.paynetsystem.domain.Order;
import com.paynetsystem.domain.Product;
import com.paynetsystem.service.OrderService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderServiceTest {

    private final OrderService orderService = new OrderService();
    private final Customer customer = new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");
    private final Product monitor = new Product(1, "Monitor", 6000);
    private final Product wirelessMouse = new Product(2, "Wireless Mouse", 200);
    private final Product ergonomicKeyboard = new Product(3, "Ergonomic Keyboard", 1000);

    @Test
    void createOrder_returnsEmptyOrderForCustomer() {
        Order order = orderService.createOrder(1, customer);

        assertEquals(1, order.getId());
        assertEquals(customer, order.getCustomer());
        assertEquals(0.0, orderService.calculateTotals(order), 0.0001);
    }

    @Test
    void addProductsToOrder_andCalculateTotals_matchDomain() {
        Order order = orderService.createOrder(1, customer);
        orderService.addProductsToOrder(order, monitor, 1);
        orderService.addProductsToOrder(order, wirelessMouse, 2);
        orderService.addProductsToOrder(order, ergonomicKeyboard, 1);

        assertEquals(7400.0, orderService.calculateTotals(order), 0.0001);
        assertEquals(order.calculateTotal(), orderService.calculateTotals(order), 0.0001);
    }

    @Test
    void addProductsToOrder_rejectsInvalidQuantity() {
        Order order = orderService.createOrder(1, customer);

        assertThrows(IllegalArgumentException.class,
                () -> orderService.addProductsToOrder(order, monitor, 0));
    }
}