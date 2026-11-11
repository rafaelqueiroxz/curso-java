package application;

import services.BrazilianInterestService;
import services.InterestService;
import services.USAInterestService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService service = new BrazilianInterestService(2.0);
        double payment = service.payment(amount, months);

        System.out.println("\nPayment after " + months + " months: ");
        System.out.println("$" + String.format("%.2f", payment));

        sc.close();

    }
}