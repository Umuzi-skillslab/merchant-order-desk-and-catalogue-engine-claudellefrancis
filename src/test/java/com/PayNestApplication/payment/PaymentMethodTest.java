
package com.PayNestApplication.payment;

import com.PayNestApplication.domain.Customer;
import com.PayNestApplication.domain.Order;
import com.PayNestApplication.domain.Product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMethodTest {

    @Test
    void testCardPayment() {

        Order order = createOrder();

        PaymentMethod paymentMethod = new CardPayment();

        boolean result = order.checkout(paymentMethod);

        assertTrue(result);
        assertEquals("CARD", paymentMethod.getPaymentType());
    }

    @Test
    void testWalletPayment() {

        Order order = createOrder();

        PaymentMethod paymentMethod = new WalletPayment();

        boolean result = order.checkout(paymentMethod);

        assertTrue(result);
        assertEquals("WALLET", paymentMethod.getPaymentType());
    }

    @Test
    void testCorrectAmountPassedToPaymentMethod() {

        Order order = createOrder();

        RecordingPaymentMethod paymentMethod =
                new RecordingPaymentMethod();

        order.checkout(paymentMethod);

        assertEquals(order.calculateTotal(),
                paymentMethod.getReceivedAmount(), 0.001);
    }

    @Test
    void testFailedPayment() {

        Order order = createOrder();

        PaymentMethod paymentMethod = new FailedPaymentMethod();

        boolean result = order.checkout(paymentMethod);

        assertFalse(result);
    }

    private Order createOrder() {

        Customer customer = new Customer(
                1,
                "Claudelle Francis",
                "claudellefrancis@umuzi.org"
        );

        Product monitor = new Product(1, "Monitor", 5000);
        Product keyboard = new Product(2, "Keyboard", 500);

        Order order = new Order(1, customer);

        order.addItem(monitor, 2);
        order.addItem(keyboard, 3);

        return order;
    }

    private static class RecordingPaymentMethod
            implements PaymentMethod {

        private double receivedAmount;

        @Override
        public boolean processPayment(double amount) {

            receivedAmount = amount;

            return true;
        }

        @Override
        public String getPaymentType() {
            return "TEST";
        }

        public double getReceivedAmount() {
            return receivedAmount;
        }
    }

    private static class FailedPaymentMethod
            implements PaymentMethod {

        @Override
        public boolean processPayment(double amount) {
            return false;
        }

        @Override
        public String getPaymentType() {
            return "FAILED PAYMENT";
        }
    }
}
