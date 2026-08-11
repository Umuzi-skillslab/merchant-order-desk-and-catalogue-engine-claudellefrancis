package com.paynetsystem.app;

import com.paynetsystem.domain.Customer;
import com.paynetsystem.domain.Order;
import com.paynetsystem.domain.Product;
import com.paynetsystem.payment.CardPayment;
import com.paynetsystem.payment.PaymentMethod;
import com.paynetsystem.service.OrderService;


public class PayNestApplication {

    public static void main(String[] args) throws Exception {

        Product monitor = new Product(1, "Monitor", 6000);
        Product wirelessMouse = new Product(2, "Wireless Mouse", 200);
        Product ergonomicKeyboard = new Product(3, "Ergonomic Keyboard", 1000);

        Customer customer = new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");

        OrderService orderService = new OrderService();
        Order order = orderService.createOrder(1, customer);

        orderService.addProductsToOrder(order, monitor, 1);
        orderService.addProductsToOrder(order, wirelessMouse, 2);
        orderService.addProductsToOrder(order, ergonomicKeyboard, 1);

        order.printSummary();

        PaymentMethod paymentMethod = new CardPayment();
        order.checkout(paymentMethod);
    }
}