package lambdaExpression;

import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String toString() {
        return type + ": " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
                new Alert("Critical", "Patient heart rate abnormal"),
                new Alert("Info", "Daily report ready"),
                new Alert("Warning", "Low oxygen level detected"),
                new Alert("Critical", "Emergency in ward 3"));

        Predicate<Alert> filter = a -> a.type.equals("Critical");

        alerts.stream()
                .filter(filter)
                .forEach(System.out::println);
    }
}
