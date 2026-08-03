package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderSummaryFormattingTest {

    @Test
    void summaryFormatterIncludesOrderDetailsAndTotals() {
        Customer customer = new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");
        Order order = new Order(1, customer);
        order.addItem(new Product(1, "Monitor", 6000), 1);

        String summary = new OrderSummaryFormatter().format(order);

        assertTrue(summary.contains("Order ID: 1"));
        assertTrue(summary.contains("Customer: Claudelle Francis"));
        assertTrue(summary.contains("Monitor"));
        assertTrue(summary.contains("Total: R6000"));
    }
}
