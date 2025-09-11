package lambdaExpression.collectors;

import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double total;

    Order(String customer, double total) {
        this.customer = customer;
        this.total = total;
    }

    public String getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }
}

public class OrderRevenueSummary {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Alice", 250.50),
                new Order("Bob", 120.75),
                new Order("Alice", 180.25),
                new Order("Bob", 300.00),
                new Order("Charlie", 90.00));

        Map<String, Double> revenueByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(Order::getTotal)));

        revenueByCustomer.forEach((customer, total) -> System.out.println(customer + " -> " + total));
    }
}
