package application;

import entities.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        Set<Student> students = new HashSet<>();

        System.out.print("How many students for course A? ");
        int studentsA = sc.nextInt();

        for (int i = 1; i <= studentsA; i++) {
            students.add(new Student(sc.nextInt()));
        }

        System.out.print("How many students for course B? ");
        int studentsB = sc.nextInt();

        for (int i = 1; i <= studentsB; i++) {
            students.add(new Student(sc.nextInt()));
        }

        System.out.print("How many students for course C? ");
        int studentsC = sc.nextInt();

        for (int i = 1; i <= studentsC; i++) {
            students.add(new Student(sc.nextInt()));
        }

        System.out.println("\nTotal students: " + students.size());



        sc.close();

    }

}