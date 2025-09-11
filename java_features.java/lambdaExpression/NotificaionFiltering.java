import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
                new Alert("Critical", "Patient heart rate abnormal"),
                new Alert("Info", "Daily medication reminder"),
                new Alert("Warning", "Blood pressure slightly high"),
                new Alert("Critical", "Emergency in Ward 3"),
                new Alert("Info", "Appointment at 5 PM"));

        Predicate<Alert> criticalOnly = a -> a.type.equals("Critical");
        Predicate<Alert> infoOnly = a -> a.type.equals("Info");
        Predicate<Alert> warningOrCritical = a -> a.type.equals("Warning") || a.type.equals("Critical");

        System.out.println("Critical Alerts:");
        alerts.stream().filter(criticalOnly).forEach(System.out::println);

        System.out.println("\nInfo Alerts:");
        alerts.stream().filter(infoOnly).forEach(System.out::println);

        System.out.println("\nWarning or Critical Alerts:");
        alerts.stream().filter(warningOrCritical).forEach(System.out::println);
    }
}
