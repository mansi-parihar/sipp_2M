package lambdaExpression;

import java.util.*;
import java.util.stream.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    public String toString() {
        return name + " - " + specialty + " (Weekend: " + availableOnWeekend + ")";
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Smith", "Cardiology", true),
                new Doctor("Dr. Lee", "Orthopedics", false),
                new Doctor("Dr. Adams", "Neurology", true),
                new Doctor("Dr. Brown", "Dermatology", true),
                new Doctor("Dr. Patel", "Pediatrics", false));

        doctors.stream()
                .filter(d -> d.availableOnWeekend)
                .sorted(Comparator.comparing(d -> d.specialty))
                .forEach(System.out::println);
    }
}
