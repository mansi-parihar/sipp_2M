import java.util.Scanner;

public class SimpleTemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        System.out.print("Convert to Celsius (C) or Fahrenheit (F)? ");
        char unit = sc.next().toUpperCase().charAt(0);

        if (unit == 'C') {
            double celsius = (temp - 32) * 5 / 9;
            System.out.println(temp + "°F = " + celsius + "°C");
        } else if (unit == 'F') {
            double fahrenheit = (temp * 9 / 5) + 32;
            System.out.println(temp + "°C = " + fahrenheit + "°F");
        } else {
            System.out.println("Invalid input.");
        }
    }
}
