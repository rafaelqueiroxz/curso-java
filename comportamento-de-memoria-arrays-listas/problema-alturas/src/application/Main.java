/*

    Fazer um programa para ler nome, idade e altura de N pessoas,
    conforme exemplo. Depois, mostrar na tela a altura média das
    pessoas, e mostrar também a porcentagem de pessoas com menos
    de 16 anos, bem como os nomes dessas pessoas caso houver.

*/

package application;

import entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serão digitadas? ");
        int n = sc.nextInt();

        Pessoa[] pessoas = new Pessoa[n];

        for (int i = 0; i < pessoas.length; i++) {

            sc.nextLine();
            System.out.printf("\nDados da %da pessoa: \n", i+1);
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            float altura = sc.nextFloat();

            pessoas[i] = new Pessoa(nome, idade, altura);

        }

        float mediaAlturas = 0;
        for (int i = 0; i < pessoas.length; i++) {
            mediaAlturas += pessoas[i].getAltura();
        }
        mediaAlturas /= pessoas.length;

        int qtdMenor16 = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() < 16) {
                qtdMenor16++;
            }
        }

        float porcentoMenor16 = qtdMenor16 * 100 / pessoas.length;

        System.out.printf("\nAltura média: %.2f%n", mediaAlturas);
        System.out.printf("Pessoas com menos de 16 anos: %.2f%%%n", porcentoMenor16);

        for (int i = 0; i < pessoas.length; i++) {
            if  (pessoas[i].getIdade() < 16) {
                System.out.println(pessoas[i].getNome());
            }
        }

        sc.close();
    }
}