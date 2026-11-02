/*

    Faça um programa que leia um número inteiro positivo N
    (máximo = 10) e depois N números inteiros e armazene-os
    em um vetor. Em seguida, mostrar na tela todos os números
    negativos lidos.

*/

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numero você vai digitar? ");
        int n = sc.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = sc.nextInt();
        }

        System.out.println("\nNUMEROS NEGATIVOS:");
        for (int i = 0; i < n; i++) {
            if (vetor[i] < 0) {
                System.out.println(vetor[i]);
            }
        }


        sc.close();
    }
}