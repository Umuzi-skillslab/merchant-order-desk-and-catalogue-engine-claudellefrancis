package com.PayNestApplication.payment;

public interface PaymentMethod {

    boolean processPayment(double amount);

    String getPaymentType();
}
