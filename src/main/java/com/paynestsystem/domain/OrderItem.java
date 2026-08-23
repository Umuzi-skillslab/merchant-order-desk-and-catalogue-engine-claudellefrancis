package com.paynestsystem.domain;

public class OrderItem {

    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive integer, got: " + quantity);
        }
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}