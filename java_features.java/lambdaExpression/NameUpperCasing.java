package lambdaExpression;

import java.util.*;
import java.util.stream.*;

public class NameUpperCasing {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Alice", "Bob", "Charlie", "Diana");
        employees.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
