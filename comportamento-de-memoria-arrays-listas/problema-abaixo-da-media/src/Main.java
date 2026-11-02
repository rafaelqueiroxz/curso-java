/*

    Fazer um programa para ler um número inteiro N e
    depois um vetor de N números reais. Em seguida,
    mostrar na tela a média aritmética de todos elementos
    com três casas decimais. Depois mostrar todos os elementos
    do vetor que estejam abaixo da média, com uma casa decimal cada.

*/

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();

        float[] vetor = new float[n];

        float media = 0;
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextFloat();
            media += vetor[i];
        }
        media /= vetor.length;

        System.out.printf("\nMEDIA DO VETOR: %.3f%n", media);
        System.out.println("ELEMENTOS ABAIXO DA MÉDIA: ");
        for (int i = 0; i < vetor.length; i++) {

            if (vetor[i] < media) {
                System.out.println(vetor[i]);
            }

        }


        sc.close();

    }
}