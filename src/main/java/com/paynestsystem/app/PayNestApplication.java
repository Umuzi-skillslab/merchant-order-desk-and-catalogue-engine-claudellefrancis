package com.paynestsystem.app;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.service.OrderService;

public class PayNestApplication {

    public static void main(String[] args) throws Exception {

        Product monitor = new Product(1, "Monitor", 6000);
        Product wirelessMouse = new Product(2, "Wireless Mouse", 200);

        Customer customer = new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");

        OrderService orderService = new OrderService();
        Order order = orderService.createOrder(1, customer);

        orderService.addProductsToOrder(order, monitor, 1);
        orderService.addProductsToOrder(order, wirelessMouse, 2);

        order.printSummary();

    }
}
