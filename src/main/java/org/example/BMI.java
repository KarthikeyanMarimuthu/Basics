package org.example;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height in centimeters: ");
        int heightInCm = sc.nextInt();
        System.out.print("Enter weight in kilograms: ");
        int weightInKg = sc.nextInt();

        // Convert height to meters
        double heightInMeters = heightInCm / 100.0;

        // Calculate BMI and determine category
        getBMI(heightInMeters, weightInKg);
    }

    public static void getBMI(double height, double weight) {
        // Calculate BMI
        double bmi = weight / (height * height);

        // Determine BMI category
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("Normal");
        } else if (bmi <= 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }

        // Print the BMI with one decimal place
        System.out.printf("BMI: %.1f%n", bmi);
    }
}
