//CP - Write a program to find the distance in yards and miles for the distance provided by the user in feet
//Hint => 1 mile = 1760 yards and 1 yard is 3 feet
//I/P => distanceInFeet
//O/P => The distance in yards is ___ while the distance in miles is ___

import java.util.Scanner;

class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = input.nextDouble();

        
        double distanceInYards = distanceInFeet / 3;      
        double distanceInMiles = distanceInYards / 1760;  

        
        System.out.printf("The distance in yards is %.2f while the distance in miles is %.5f", distanceInYards, distanceInMiles);
    }
}
