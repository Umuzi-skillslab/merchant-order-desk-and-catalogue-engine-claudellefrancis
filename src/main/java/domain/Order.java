package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        items.add(new OrderItem(product, quantity));
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.calculateTotal();
        }
        return total;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void printSummary() {
        System.out.println("Order summary");
        System.out.println("========================");
        System.out.println("Order ID: " + id);
        System.out.println("Customer: " + customer.name());
        System.out.println("Email: " + customer.email());
        System.out.println("========================");
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.println(" - " + item.product().getName() + " | QTY: " + item.quantity() + " | R" + String.format("%.0f", item.calculateTotal()));
        }
        System.out.println("========================");
        System.out.println("Total: R" + String.format("%.0f", calculateTotal()));
        System.out.println("========================");
    }
    
}