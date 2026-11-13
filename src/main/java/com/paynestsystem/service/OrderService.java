package com.paynetsystem.service;

import com.paynetsystem.domain.Customer;
import com.paynetsystem.domain.Order;
import com.paynetsystem.domain.Product;


public class OrderService {

    public Order createOrder(int orderId, Customer customer) {
        return new Order(orderId, customer);
    }

    public void addProductsToOrder(Order order, Product product, int quantity) {

        if(product == null) {
            throw new IllegalArgumentException("Product cannot be null and quantity must be greater than zero.");
        }

        if(quantity > product.getStockQuantity()) {
            throw new IllegalArgumentException("Quantity exceeds available stock.");
        }
        order.addItem(product, quantity);
    }

    public double calculateTotals(Order order) {
        return order.calculateTotal();
    }
}