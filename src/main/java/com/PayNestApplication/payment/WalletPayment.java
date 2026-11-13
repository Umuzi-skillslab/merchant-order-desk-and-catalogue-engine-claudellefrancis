package com.PayNestApplication.payment;

public class WalletPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing wallet payment of R" + String.format("%.0f", amount));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}
