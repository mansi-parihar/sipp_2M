package lambdaExpression;

import java.util.*;

public class EventAttendanceWelcome {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList("John", "Emma", "Liam", "Sophia");
        attendees.forEach(name -> System.out.println("Welcome, " + name + "!"));
    }
}
