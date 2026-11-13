package com.paynestsystem.app;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.payment.PaymentMethod;
import com.paynestsystem.payment.WalletPayment;
import com.paynestsystem.service.OrderService;

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
