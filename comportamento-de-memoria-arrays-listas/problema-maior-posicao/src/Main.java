/*

    Faça um programa que leia N números reais e armazene-os em um
    vetor. Em seguida, mostrar na tela o maior número do vetor
    (supor não haver empates). Mostrar também a posição do maior
    elemento, considerando a primeira posição como 0 (zero).

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

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextFloat();
        }

        float maiorValor = vetor[0];
        int posicao = 0;
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maiorValor) {
                maiorValor = vetor[i];
                posicao = i;
            }
        }

        System.out.printf("\nMAIOR VALOR = %.1f\n", maiorValor);
        System.out.println("POSIÇÃO MAIOR VALOR = " + posicao);

        sc.close();

    }
}