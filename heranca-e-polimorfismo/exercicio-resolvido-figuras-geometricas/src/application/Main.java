package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        List<Shape> shapes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nShape #" + i + " data: ");
            System.out.print("Rectangle or Circle (r/c)? ");
            char choice = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            sc.nextLine();
            Color color = Color.valueOf(sc.nextLine().toUpperCase());
            if (choice == 'r' || choice == 'R') {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                shapes.add(new Rectangle(color, width, height));
            } else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                shapes.add(new Circle(color, radius));
            }
        }

        System.out.println("\nShapes areas: ");

        for (Shape s : shapes) {
            System.out.println(String.format("%.2f", s.area()));
        }

        sc.close();

    }
}