import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("Default Format (yyyy-MM-dd): " +
                DateUtils.formatDate(today, "yyyy-MM-dd"));

        System.out.println("Indian Format (dd/MM/yyyy): " +
                DateUtils.formatDate(today, "dd/MM/yyyy"));

        System.out.println("US Format (MM-dd-yyyy): " +
                DateUtils.formatDate(today, "MM-dd-yyyy"));

        System.out.println("Full Month Format: " +
                DateUtils.formatDate(today, "dd-MMMM-yyyy"));

        System.out.println("Invoice Friendly (dd MMM, yyyy): " +
                DateUtils.formatDate(today, "dd MMM, yyyy"));
    }
}