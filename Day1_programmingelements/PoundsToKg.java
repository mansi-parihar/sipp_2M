//Question 21
//CP - Create a program to convert weight from pounds to kilograms.
//Hint => 1 pound = 2.2 kg
//I/P => weight
//O/P => The weight of the person in pounds is ___ and in kg is ___

import java.util.Scanner;

class PoundsToKg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double pounds = input.nextDouble();
        double kg = pounds / 2.2;
        System.out.println("The weight of the person in pounds is " + pounds + " and in kg is " + kg);
    }
}








