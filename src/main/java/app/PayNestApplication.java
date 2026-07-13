package app;

import domain.Customer;
import domain.Order;
import domain.Product;
import service.OrderService;

public class PayNestApplication {

    public static void main(String[] args) {
        Product monitor = new Product(1, "Monitor", 6000);
        Product wirelessMouse = new Product(2, "Wireless Mouse", 200);
        Product ergonomicKeyboard = new Product(3, "Ergonomic Keyboard", 1000);

        Customer customer = new Customer(1, "Claudelle Francis", "claudelle.francis@umuzi.org");

        Order order = new Order(1, customer);

        OrderService orderService = new OrderService();
        orderService.addProductsToOrder(order, monitor, 1);
        orderService.addProductsToOrder(order, wirelessMouse, 2);
        orderService.addProductsToOrder(order, ergonomicKeyboard, 1);

        order.printSummary();

        
    }
}
