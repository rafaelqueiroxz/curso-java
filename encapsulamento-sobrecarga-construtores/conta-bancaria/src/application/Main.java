package application;

import entities.ContaBancaria;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ContaBancaria contaBancaria;

        System.out.println("Bem vindo ao Rafael´s Bank!\n");
        System.out.print("Entre com o número da sua conta: ");
        int numeroConta = sc.nextInt();
        sc.nextLine();
        System.out.print("Entre com o nome do titular da conta: ");
        String titularConta = sc.nextLine();
        System.out.print("Você deseja fazer um depósito inicial (S/N)? ");
        char opcao = sc.next().charAt(0);

        if (opcao == 'N' ||  opcao == 'n') {
            contaBancaria = new ContaBancaria(numeroConta, titularConta);
        } else {
            System.out.print("\nEntre com o valor do depósito inicial: R$ ");
            double depositoInicial = sc.nextDouble();
            contaBancaria = new ContaBancaria(numeroConta, titularConta, depositoInicial);
        }

        System.out.println("\n" + contaBancaria);

        System.out.print("\nEntre com o valor do depósito: R$ ");
        contaBancaria.depositar(sc.nextDouble());

        System.out.println("\nAtualização dos " + contaBancaria);

        System.out.print("\nEntre com o valor do saque: R$ ");
        contaBancaria.sacar(sc.nextDouble());

        System.out.println("\nAtualização dos " + contaBancaria);

    }
}