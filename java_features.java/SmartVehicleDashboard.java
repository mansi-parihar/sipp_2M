interface Vehicle {
    void displaySpeed(int speed);

    default void displayBattery(int batteryPercent) {
        System.out.println("Battery info not available for this vehicle.");
    }
}

class Car implements Vehicle {
    public void displaySpeed(int speed) {
        System.out.println("Car speed: " + speed + " km/h");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed(int speed) {
        System.out.println("Electric Car speed: " + speed + " km/h");
    }

    @Override
    public void displayBattery(int batteryPercent) {
        System.out.println("Battery charge: " + batteryPercent + "%");
    }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle tesla = new ElectricCar();

        System.out.println("=== Car Dashboard ===");
        car.displaySpeed(80);
        car.displayBattery(0);

        System.out.println("\n=== Electric Car Dashboard ===");
        tesla.displaySpeed(100);
        tesla.displayBattery(85);
    }
}
