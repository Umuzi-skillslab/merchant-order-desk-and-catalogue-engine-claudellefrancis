package domain;

import java.util.Objects;

public record OrderItem(Product product, int quantity) {

    public OrderItem {
        Objects.requireNonNull(product, "Product must not be null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }

    public double calculateTotal() {
        return product.getPrice() * quantity;
    }
}
