package com.PayNestApplication.payment;

public class PayflexPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Payflex payment for R" +
            String.format("%.0f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "Payflex";
    }
}