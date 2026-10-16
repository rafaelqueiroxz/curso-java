package application;

import entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Rectangle rectangle = new Rectangle();

        System.out.println("Enter rectangle width and height: ");
        rectangle.width = sc.nextDouble();
        rectangle.height = sc.nextDouble();

        System.out.println("\nArea: " + rectangle.area());
        System.out.println("Perimeter: " + rectangle.perimeter());
        System.out.println("Diagonal: " + rectangle.diagonal());

        sc.close();
    }
}