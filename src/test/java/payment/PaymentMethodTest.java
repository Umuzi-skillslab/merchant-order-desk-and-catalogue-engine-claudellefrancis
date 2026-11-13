package payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.PayNestApplication.payment.PaymentMethod;
import com.PayNestApplication.payment.WalletPayment;
import com.PayNestApplication.payment.CardPayment;

class PaymentMethodTest {

    @Test
    void checkoutCanUseDifferentPaymentMethods() {
        PaymentMethod card = new CardPayment();
        PaymentMethod wallet = new WalletPayment();

        assertTrue(card.processPayment(12400));
        assertTrue(wallet.processPayment(12400));
        assertEquals("CARD", card.getPaymentType());
        assertEquals("WALLET", wallet.getPaymentType());
    }
}