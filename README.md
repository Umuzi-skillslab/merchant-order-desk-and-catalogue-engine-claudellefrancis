# Unified-checkout-across-payment-rails

The PaymentMethod interface applied polymorphism and the Dependency Inversion Principle.

The checkout process depends on the PaymentMethod abstraction instead of concrete payment classes such as CardPayment or EftPayment.

This makes the system extensible because new payment rails can be added by creating a new clasdd that implements PaymentMethod without modifying the order calculation or checkout logic. For example, adding BuyNowPayLaterPayment would only require a new implementation class and application wiring, leaving existing business rules unchanged.