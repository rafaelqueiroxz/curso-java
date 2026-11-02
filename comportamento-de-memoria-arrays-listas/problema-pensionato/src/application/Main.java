/*
    A dona de um pensionato possui dez quartos para alugar para
    estudantes, sendo esses quartos identificados pelos números
    0 a 9.

    Fazer um programa que inicie com todos os dez quartos vazios,
    e depois leia uma quantidade N representando o número de
    estudantes que vão alugar quartos (N pode ser de 1 a 10). Em
    seguida, registre o aluguel dos N estudantes. Para cada registro
    de aluguel, informar o nome e email do estudante, bem como qual
    dos quartos ele escolheu (de 0 a 9). Suponha que seja escolhido
    um quarto vago. Ao final, seu programa deve imprimir um relatório
    de todas ocupações do pensionato, por ordem de quarto, conforme
    exemplo.
*/


package application;

import entities.Estudante;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Estudante[] quartos = new Estudante[10];

        System.out.print("Quantos quartos serão alugados? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sc.nextLine();
            System.out.println("\nReserva #" + i + ":");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Quarto: ");
            int numeroQuarto = sc.nextInt();

            quartos[numeroQuarto] = new Estudante(nome, email);
        }

        System.out.println("\nQuartos ocupados: ");
        for (int i = 0; i < quartos.length; i++) {
            if (quartos[i] != null) {
                System.out.println(i + ": " + quartos[i].getNome()
                 + ", " + quartos[i].getEmail());
            }
        }


        sc.close();

    }
}