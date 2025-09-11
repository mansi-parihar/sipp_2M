interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double milesToKm(double miles) {
        return miles * 1.60934;
    }

    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }

    static double lbsToKg(double lbs) {
        return lbs * 0.453592;
    }
}

public class LogisticsApp {
    public static void main(String[] args) {
        double distanceKm = 10.0;
        double weightKg = 50.0;

        System.out.println(distanceKm + " km = " + UnitConverter.kmToMiles(distanceKm) + " miles");
        System.out.println("6.2 miles = " + UnitConverter.milesToKm(6.2) + " km");

        System.out.println(weightKg + " kg = " + UnitConverter.kgToLbs(weightKg) + " lbs");
        System.out.println("110 lbs = " + UnitConverter.lbsToKg(110) + " kg");
    }
}
