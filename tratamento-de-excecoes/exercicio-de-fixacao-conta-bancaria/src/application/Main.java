package application;

import model.entities.Account;
import model.exceptios.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Entre com as informações da conta");
            System.out.print("Numero da conta: ");
            int numero = sc.nextInt();
            System.out.print("Nome do titular: ");
            sc.nextLine();
            String titular = sc.nextLine();
            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();
            System.out.print("Limite de saque: ");
            double limiteSaque = sc.nextDouble();

            Account account = new Account(numero, titular, saldo, limiteSaque);

            System.out.print("\nEntre com o valor do saque: ");
            account.saque(sc.nextDouble());

            System.out.println(account);

        } catch (DomainException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro no sistema.");
        }


        sc.close();

    }
}