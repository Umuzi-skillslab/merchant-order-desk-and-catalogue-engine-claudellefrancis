package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Product {

    private final int id;
    private final String name;
    private final BigDecimal price;

    public Product(int id, String name, double price) {
        this(id, name, BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP));
    }

    public Product(int id, String name, BigDecimal price) {
        if (id <= 0) {
            throw new IllegalArgumentException("Product ID must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name must be provided");
        }
        this.id = id;
        this.name = name;
        this.price = Objects.requireNonNull(price, "Price must not be null");
        if (this.price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be non-negative");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price.doubleValue();
    }

    public BigDecimal getPriceAsBigDecimal() {
        return price;
    }
}
