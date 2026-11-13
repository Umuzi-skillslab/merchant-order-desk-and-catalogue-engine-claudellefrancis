# PayNest – Unified Checkout Across Payment Rails

## Project Overview

PayNest is a Java-based checkout application that demonstrates how a single order can be processed through multiple payment methods using object-oriented programming principles.

The project implements a unified payment system using **interfaces and polymorphism**, allowing customers to complete an order using different payment rails without changing the underlying order calculation or checkout logic.

The application builds on the existing order management functionality and introduces a flexible payment architecture that can accommodate additional payment methods with minimal changes to the existing code.

## Project Objectives

The main objectives of this project are to:

- Implement a common payment interface.
- Support multiple payment methods through a unified checkout process.
- Apply polymorphism to process payments without depending on specific payment implementations.
- Calculate the order grand total using existing order and order-item calculations.
- Handle successful and unsuccessful payment outcomes.
- Demonstrate the flexibility of the system by allowing new payment methods to be added without modifying the core checkout logic.
- Use JUnit 5 to test payment processing and order calculations.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Application development |
| Maven | Project and dependency management |
| JUnit 5 | Unit testing |
| Visual Studio Code | Development environment |
| Git and GitHub | Version control and project hosting |

## Project Structure

```text
unified-checkout-across-payment-rails/
│
├── pom.xml
├── README.md
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── PayNestApplication/
    │               │
    │               ├── app/
    │               │   └── PayNestApplication.java
    │               │
    │               ├── domain/
    │               │   ├── Customer.java
    │               │   ├── Order.java
    │               │   ├── OrderItem.java
    │               │   └── Product.java
    │               │
    │               ├── payment/
    │               │   ├── PaymentMethod.java
    │               │   ├── PaymentProcessor.java
    │               │   ├── CardPayment.java
    │               │   ├── EftPayment.java
    │               │   ├── WalletPayment.java
    │               │   └── PayflexPayment.java
    │               │
    │               └── service/
    │                   └── OrderService.java
    │
    └── test/
        └── java/
            └── com/
                └── PayNestApplication/
                    │
                    ├── domain/
                    │   └── OrderTest.java
                    │
                    ├── payment/
                    │   └── PaymentMethodTest.java
                    │
                    └── service/
                        └── OrderServiceTest.java
```

## Payment Architecture

### 1. PaymentMethod Interface

The `PaymentMethod` interface defines the standard contract that every payment implementation must follow.

It contains two methods:

```java
public interface PaymentMethod {

    boolean processPayment(double amount);

    String getPaymentType();
}
```

- `processPayment(double amount)` processes the payment and returns a boolean indicating whether the payment was successful.
- `getPaymentType()` identifies the payment method being used.

This interface ensures that all payment implementations follow the same structure.

### 2. Supported Payment Methods

PayNest currently supports four payment implementations:

| Payment Method | Class |
|---|---|
| Card | CardPayment |
| Electronic Funds Transfer | EftPayment |
| Digital Wallet | WalletPayment |
| Buy Now, Pay Later | PayflexPayment |

Each class implements the `PaymentMethod` interface and provides its own payment-processing behaviour.

The current implementations simulate successful payments by returning `true`. They do not connect to external payment gateways or process real financial transactions.

### 3. PaymentProcessor

The `PaymentProcessor` class provides a central point for processing payments.

It accepts the `PaymentMethod` interface rather than a specific payment implementation.

This allows the processor to work with any class that implements the interface.

The processor:

- Receives the selected payment method and payment amount.
- Calls the payment implementation.
- Checks whether the payment was successful.
- Displays the appropriate success or failure message.
- Returns the payment result.

### 4. Order Checkout

The `Order` class contains the checkout functionality.

Before payment is processed, the application calculates the grand total by adding the totals of all order items.

The calculated amount is then passed to the payment processor.

The checkout method returns:

- `true` when payment is successful.
- `false` when payment fails.

A successful payment results in an order completion confirmation. A failed payment is handled centrally and does not result in a successful order completion message.

## How Polymorphism Is Implemented

One of the main design principles demonstrated in this project is polymorphism.

Instead of creating separate checkout methods for card, EFT, wallet and Payflex payments, the application uses the common `PaymentMethod` interface.

For example:

```java
PaymentMethod paymentMethod = new CardPayment();

order.checkout(paymentMethod);
```

To use another payment method, the implementation can simply be changed:

```java
PaymentMethod paymentMethod = new WalletPayment();

order.checkout(paymentMethod);
```

The same checkout method works with both implementations.

This approach reduces code duplication, improves maintainability and makes the application easier to extend.

## Adding a New Payment Method

The application is designed to support additional payment methods without modifying the existing order calculation or checkout architecture.

For example, a new Buy Now, Pay Later payment implementation can be introduced by creating a class that implements `PaymentMethod`.

```java
public class BuyNowPayLaterPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println(
            "Processing Buy Now, Pay Later payment of R"
            + String.format("%.0f", amount)
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "BUY NOW PAY LATER";
    }
}
```

The new implementation can then be selected in the application without changing the existing order calculation or generic payment processor.

## Getting Started

### Prerequisites

Before running the application, ensure that you have installed:

- Java Development Kit (JDK) 17 or later.
- Apache Maven.
- Visual Studio Code or another Java-compatible IDE.
- Git (optional, for cloning the repository).

### Clone the Repository

```bash
git clone <your-github-repository-url>
```

Navigate into the project directory:

```bash
cd unified-checkout-across-payment-rails
```

### Build the Project

Run the following command to compile the application:

```bash
mvn clean compile
```

### Run the Application

To launch PayNest using Maven:

```bash
mvn exec:java
```

### Run the Unit Tests

To execute the JUnit 5 tests, run:

```bash
mvn clean test
```

Maven will compile the application, compile the test classes and execute the available unit tests.

## Testing

JUnit 5 is used to verify the application's functionality.

The project includes the following test classes:

| Test Class | Testing Focus |
|---|---|
| OrderTest | Verifies that the grand total is calculated correctly. |
| PaymentMethodTest | Tests card payments, wallet payments, payment amount handling and unsuccessful payments. |
| OrderServiceTest | Tests the existing order service functionality. |

### Test Results

The project successfully passed all six unit tests.

```text
Tests run: 6
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

The tests confirm that:

- Order totals are calculated correctly.
- Card payments are processed successfully.
- Wallet payments are processed successfully.
- The correct order grand total is passed to the payment method.
- Failed payments are handled correctly.
- Existing order service functionality continues to work.

## Key Design Principles Demonstrated

### Abstraction
The `PaymentMethod` interface defines the required payment operations without exposing the implementation details of individual payment methods.

### Encapsulation
Payment-processing behaviour is contained within its respective payment classes.

### Polymorphism
Different payment implementations can be used through the same interface and checkout method.

### Open/Closed Principle
The payment architecture is designed to allow new payment implementations to be introduced without modifying the existing core checkout logic.

### Separation of Responsibilities
Order calculation, payment processing and individual payment implementations are handled by separate classes.

## Future Enhancements

Possible improvements for future versions include:

- Integration with real payment gateway APIs.
- Additional payment methods.
- Improved payment validation and exception handling.
- Persistent order and payment records using a database.
- Transaction tracking and payment history.
- A graphical user interface for customers.
- More comprehensive automated testing.

## Limitations

This project is a demonstration of a unified payment architecture.

All payment implementations currently simulate payment outcomes. No real banking transactions, payment gateway integrations or external financial services are connected.

## Conclusion

PayNest demonstrates how interfaces, abstraction and polymorphism can be used to build a flexible and maintainable checkout system.

By introducing a common payment interface, the application allows different payment methods to operate through one generic checkout process.

This design reduces dependency on individual payment implementations and makes it easier to introduce new payment options without changing the existing order calculation and payment-processing structure.

The successful execution of all six JUnit tests confirms that the implemented functionality works as expected.

---

**Project:** PayNest – Unified Checkout Across Payment Rails
**Language:** Java 17
**Build Tool:** Maven
**Testing Framework:** JUnit 5
**Status:** Successfully built and tested
**Author:** Claudelle Francis
