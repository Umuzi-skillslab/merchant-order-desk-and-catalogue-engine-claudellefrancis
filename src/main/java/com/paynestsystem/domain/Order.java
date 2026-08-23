package com.paynestsystem.domain;

import java.util.ArrayList;
import java.util.Collections;
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

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
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
        System.out.println("========================");
        System.out.println("Order ID: " + id);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("========================");
        System.out.println("Items:");
        for (OrderItem item : items) {
            String line = item.getProduct().getName() + " x" + item.getQuantity()
                    + " - R" + String.format("%.0f", item.calculateTotal());
            System.out.println(line);
        }
        System.out.println("========================");
        System.out.println("Total: R" + String.format("%.0f", calculateTotal()));
        System.out.println("========================");
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}