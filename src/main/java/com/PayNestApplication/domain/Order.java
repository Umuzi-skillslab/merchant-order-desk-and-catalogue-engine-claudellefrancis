package com.PayNestApplication.domain;

import com.PayNestApplication.payment.PaymentMethod;
import com.PayNestApplication.payment.PaymentProcessor;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int id;
    private final Customer customer;
    private final List<OrderItem> items;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        // Students can extend here: add validation (e.g. quantity > 0, product not null)
        if(product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if(product.getPrice() <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero");
        }
        OrderItem orderItem = new OrderItem(product, quantity);
        items.add(orderItem);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            total = total + item.calculateTotal();
        }
        return total;
    }

    public void printSummary() {
        System.out.println("Order Summary");
        System.out.println("Customer: " + customer.getName());
        System.out.println();
        System.out.println("Items:");
        for (OrderItem item : items) {
            String line = item.getProduct().getName() + " x" + item.getQuantity()
                    + " - R" + String.format("%.0f", item.calculateTotal());
            System.out.println(line);
        }
        System.out.println();
        System.out.println("Total: R" + String.format("%.0f", calculateTotal()));
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void checkout(PaymentMethod paymentMethod) {
        double total = calculateTotal();
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(paymentMethod, total);
        System.out.println("Order completed successfully.");
    }
}
