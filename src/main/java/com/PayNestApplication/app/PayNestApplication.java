package com.PayNestApplication.app;

import com.PayNestApplication.domain.Customer;
import com.PayNestApplication.domain.Order;
import com.PayNestApplication.domain.Product;
import com.PayNestApplication.payment.PaymentMethod;
import com.PayNestApplication.payment.PayflexPayment;

public class PayNestApplication {

    public static void main(String[] args) {

        Product monitor = new Product(1, "Monitor", 5000);
        Product iPad = new Product(3, "iPad", 15000);
        Product keyboard = new Product(4, "Keyboard", 500);


        Customer customer = new Customer(
            1,
            "Claudelle Francis",
            "claudellefrancis@umuzi.org");

        Order order = new Order(1, customer);
        order.addItem(monitor, 1);
        order.addItem(iPad, 4);
        order.addItem(keyboard, 3);

        order.printSummary();

        PayflexPayment paymentMethod = new PayflexPayment();
        order.checkout((PaymentMethod) (Object) paymentMethod);
    }
}
