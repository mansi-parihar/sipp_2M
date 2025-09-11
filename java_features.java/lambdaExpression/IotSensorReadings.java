package lambdaExpression;

import java.util.*;
import java.util.stream.*;

public class IotSensorReadings {
    public static void main(String[] args) {
        List<Double> readings = Arrays.asList(45.5, 72.3, 60.0, 85.1, 49.9, 90.0);
        double threshold = 60.0;

        readings.stream()
                .filter(r -> r > threshold)
                .forEach(r -> System.out.println("Reading: " + r));
    }
}
