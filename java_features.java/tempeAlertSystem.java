import java.util.function.Predicate;

public class tempeAlertSystem {
    public static void main(String[] args) {
        double threshold = 40.0;
        Predicate<Double> isHighTemperature = temp -> temp > threshold;

        double[] temperatures = { 35.5, 39.9, 40.0, 41.2, 45.8 };

        for (double temp : temperatures) {
            if (isHighTemperature.test(temp)) {
                System.out.println("ALERT 🚨: Temperature " + temp + "°C crossed the threshold!");
            } else {
                System.out.println("Safe ✅: Temperature " + temp + "°C is within normal range.");
            }
        }
    }
}
