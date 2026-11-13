package com.paynestsystem.app;

import domain.Customer;
import domain.Order;
import domain.Product;
import payment.PaymentMethod;
import payment.Payflex;
import service.OrderService;

public class PayNestApplication {

    public static void main(String[] args) {

        Product laptop = new Product(1, "Laptop", 12000);
        Product mouse = new Product(3, "Mouse", 200);
        Product keyboard = new Product(4, "Keyboard", 500);


        Customer customer = new Customer(1, "Claudelle Francis", "claudellefrancis@umuzi.org");

        OrderService orderService = new OrderService();
        Order order = orderService.createOrder(1, customer);
        orderService.addProductsToOrder(order, laptop, 1);
        orderService.addProductsToOrder(order, mouse, 2);
        orderService.addProductsToOrder(order, keyboard, 1);

        order.printSummary();

        PaymentMethod paymentMethod = new WalletPayment();
        order.checkout(paymentMethod);
    }
}
