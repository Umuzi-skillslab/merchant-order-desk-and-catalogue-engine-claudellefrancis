package domain;

public record OrderItem(Product product, int quantity) {

    public OrderItem {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }

    public double calculateTotal() {
        return product.getPrice() * quantity;
    }

    public Object Product() {
        return product;
    }
    public Object getQuantity() {
        return quantity;
    }
}
