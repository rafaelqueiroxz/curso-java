/*

    Fazer um programa para ler um vetor de N números inteiros.
    Em seguida, mostrar na tela a média aritmética somente dos
    números pares lidos, com uma casa decimal. Se nenhum número
    par for digitado, mostrar a mensagem "NENHUM NUMERO PAR"

*/

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();

        int[] vetor = new int[n];

        int qtdPares = 0;
        int somaPares = 0;
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();

            if (vetor[i] % 2 == 0) {
                somaPares += vetor[i];
                qtdPares++;
            }
        }

        if (qtdPares == 0) {
            System.out.println("NENHUM NÚMERO PAR!");
        } else {
            float media = (float)somaPares / qtdPares;
            System.out.printf("MEDIA DOS PARES: %.1f%n", media);
        }

        sc.close();

    }
}