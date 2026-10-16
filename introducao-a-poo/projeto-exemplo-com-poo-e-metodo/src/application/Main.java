package application;


import entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        System.out.println("Enter the measures of triangle X: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Enter the measures of triangle Y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();


        double areaX = x.calcularArea();
        double areaY = y.calcularArea();


        System.out.printf("\nentities.Triangle X area : %.4f%n", areaX);
        System.out.printf("entities.Triangle Y area : %.4f%n", areaY);

        if (areaX > areaY) {
            System.out.println("\nLager area : X");
        } else {
            System.out.println("\nLager area : Y");
        }

        sc.close();
    }
}