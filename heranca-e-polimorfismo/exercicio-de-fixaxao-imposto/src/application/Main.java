package application;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o número de contribuintes que deseja cadastrar: ");
        int n = sc.nextInt();

        List<Contribuinte> contribuintes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nInformações do Contribuinte #" + i + ": ");
            System.out.print("CPF ou CNPJ? ");
            sc.nextLine();
            String tipoContribuinte = sc.nextLine().toUpperCase();

            if (tipoContribuinte.equals("CPF")) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Receita anual: $");
                double receitaAnual = sc.nextDouble();
                System.out.print("Despesas médicas: $");
                double despesasMedicas = sc.nextDouble();
                contribuintes.add(new PessoaFisica(nome, receitaAnual, despesasMedicas));
            } else {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Receita anual: $");
                double receitaAnual = sc.nextDouble();
                System.out.print("Numero de funcionários: ");
                int numeroDeFuncionarios = sc.nextInt();
                contribuintes.add(new PessoaJuridica(nome, receitaAnual, numeroDeFuncionarios));
            }
        }

        System.out.println("\nTaxas pagas: ");
        for (Contribuinte contribuinte : contribuintes) {
            System.out.println(contribuinte);
        }

        double sum = 0.0;
        for (Contribuinte contribuinte : contribuintes) {
            sum += contribuinte.calcularImposto();
        }
        System.out.println("\nImposto total arrecadado: $ " + String.format("%.2f", sum));




        sc.close();

    }
}