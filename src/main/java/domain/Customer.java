package domain;

public record Customer(int id, String name, String email) {

    public Customer {
        if (id <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name must be provided");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Customer email must be provided");
        }
    }
}


