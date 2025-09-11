package lambdaExpression;

import java.util.*;

public class EmailNotification {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("user1@example.com", "user2@example.com", "user3@example.com");
        emails.forEach(email -> sendEmailNotification(email));
    }

    static void sendEmailNotification(String email) {
        System.out.println("Notification sent to: " + email);
    }
}
