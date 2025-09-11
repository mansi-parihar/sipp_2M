package lambdaExpression;

import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(1523.45, 1530.10, 1528.75, 1535.20, 1540.00);
        stockPrices.forEach(System.out::println);
    }
}