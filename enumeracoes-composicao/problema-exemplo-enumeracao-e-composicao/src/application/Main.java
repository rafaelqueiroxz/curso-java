package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("\nEnter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName,
                WorkerLevel.valueOf(workerLevel),
                baseSalary,
                new Department(departmentName));

        System.out.print("\nHow many contracts to this worker? ");
        int numberOfContracts = sc.nextInt();

        for (int i = 1; i <= numberOfContracts; i++) {
            System.out.println("\nEnter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            sc.nextLine();
            LocalDate contractDate = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int durationHours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, durationHours);
            worker.addContract(contract);
        }

        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        sc.nextLine();
        String monthAndYear = sc.nextLine();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("\nName: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income from " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();

    }
}