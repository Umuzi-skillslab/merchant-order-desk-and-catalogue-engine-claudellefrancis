package com.paynetsystem.payment;

public class CardPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        // Simulated: always succeeds. Students can extend here: add failure scenarios
        return true;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}