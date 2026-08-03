package domain;

public class OrderSummaryFormatter {

    public String format(Order order) {
        StringBuilder summary = new StringBuilder();
        summary.append("Order summary\n");
        summary.append("========================\n");
        summary.append("Order ID: ").append(order.getId()).append("\n");
        summary.append("Customer: ").append(order.getCustomer().name()).append("\n");
        summary.append("Email: ").append(order.getCustomer().email()).append("\n");
        summary.append("========================\n");
        summary.append("Items:\n");
        for (OrderItem item : order.getItems()) {
            summary.append(" - ")
                    .append(item.product().getName())
                    .append(" | QTY: ")
                    .append(item.quantity())
                    .append(" | R")
                    .append(String.format("%.0f", item.calculateTotal()))
                    .append("\n");
        }
        summary.append("========================\n");
        summary.append("Total: R").append(String.format("%.0f", order.calculateTotal())).append("\n");
        summary.append("========================");
        return summary.toString();
    }
}
