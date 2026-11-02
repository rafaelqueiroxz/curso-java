/*
    Faça um programa que leia N números reais e armazene-os em
    um vetor. Em seguida:
    - Imprimir todos os elementos do vetor
    - Mostrar na tela a soma e a média dos elementos do vetor

*/

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar? ");
        int n = sc.nextInt();

        float[] vetor = new float[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = sc.nextFloat();
        }

        float soma = 0;
        System.out.print("\nValores: ");
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
            System.out.printf("%.1f ", vetor[i]);
        }
        float media = soma / vetor.length;
        System.out.printf("\nSoma: %.2f\n", soma);
        System.out.printf("Media: %.2f\n", media);

        sc.close();

    }
}