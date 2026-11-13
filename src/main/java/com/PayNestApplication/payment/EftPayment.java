package com.PayNestApplication.payment;

public class EftPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing EFT payment of R" + String.format("%.0f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "EFT";
    }
}
