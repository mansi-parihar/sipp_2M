//Question 23
//CP - Create a program to find the maximum number of handshakes among N number of students.
//Hint =>
//1. Get integer input for the numberOfStudents variable.
//2. Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of possible
//handshakes.
//3. Display the number of possible handshakes.

import java.util.Scanner;

class Handshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfStudents = input.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println("The maximum number of handshakes is " + handshakes);
    }
}









