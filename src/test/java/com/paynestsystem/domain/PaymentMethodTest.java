package com.paynetsystem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.paynetsystem.payment.CardPayment;
import com.paynetsystem.payment.EftPayment;
import com.paynetsystem.payment.PaymentMethod;
import com.paynetsystem.payment.WalletPayment;

class PaymentMethodTest {

    @Test
    void differentPaymentMethodsCanProcessPayments() {
        PaymentMethod card = new CardPayment();
        PaymentMethod wallet = new WalletPayment();

        assertTrue(card.processPayment(12400));
        assertTrue(wallet.processPayment(12400));

        assertEquals("CARD", card.getPaymentType());
        assertEquals("WALLET", wallet.getPaymentType());
    }

    @Test
    void checkoutWorksWithCardPayment() {
        Customer customer = new Customer(
            1,
            "Test Customer",
            "test@example.com"
        );

        Product laptop = new Product(1, "Laptop", 12000);
        Product mouse = new Product(2, "Mouse", 200);

        Order order = new Order(1, customer);
        order.addItem(laptop, 1);
        order.addItem(mouse, 2);

        PaymentMethod paymentMethod = new CardPayment();

        assertEquals(12400, order.calculateTotal());
        assertDoesNotThrow(() -> order.checkout(paymentMethod));
    }

    @Test
    void checkoutWorksWithWalletPayment() {
        Customer customer = new Customer(
            2,
            "Test Customer",
            "test@example.com"
        );

        Product laptop = new Product(1, "Laptop", 12000);
        Product mouse = new Product(2, "Mouse", 200);

        Order order = new Order(2, customer);
        order.addItem(laptop, 1);
        order.addItem(mouse, 2);

        PaymentMethod paymentMethod = new WalletPayment();

        assertEquals(12400, order.calculateTotal());
        assertDoesNotThrow(() -> order.checkout(paymentMethod));
    }

    @Test
    void checkoutUsesTheOrderTotal() {
        Customer customer = new Customer(
            3,
            "Test Customer",
            "test@example.com"
        );

        Product laptop = new Product(1, "Laptop", 12000);
        Product mouse = new Product(2, "Mouse", 200);

        Order order = new Order(3, customer);
        order.addItem(laptop, 1);
        order.addItem(mouse, 2);

        assertEquals(12400, order.calculateTotal());

        PaymentMethod paymentMethod = new CardPayment();

       assertDoesNotThrow(() -> order.checkout(paymentMethod));
    }
}