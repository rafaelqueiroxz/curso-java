/*

    Tem-se um conjunto de dados contendo a altura e o gênero (M, F)
    de N pessoas. Fazer um programa que calcule e escreva a maior e
    a menor altura do grupo, a média de altura das mulheres, e o
    número de homens.

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
            System.out.printf("\nAltura da %da pessoa: ", (i+1));
            float altura = sc.nextFloat();
            System.out.printf("Gênero da %da pessoa: ", (i+1));
            char sexo = sc.next().charAt(0);

            pessoas[i] = new Pessoa(altura, sexo);
        }

        int posicaoMaior = 0;
        int posicaoMenor = 0;
        for (int i = 1; i < pessoas.length; i++) {
            if (pessoas[i].getAltura() > pessoas[posicaoMaior].getAltura()) {
                posicaoMaior = i;
            } else if (pessoas[i].getAltura() < pessoas[posicaoMenor].getAltura()) {
                posicaoMenor = i;
            }
        }
        System.out.println("\nMenor altura: " + pessoas[posicaoMenor].getAltura());
        System.out.println("Maior altura: " + pessoas[posicaoMaior].getAltura());

        int qtdMulheres = 0;
        float somaAlturaMulheres = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getSexo() == 'F') {
                qtdMulheres++;
                somaAlturaMulheres += pessoas[i].getAltura();
            }
        }
        float mediaAlturaMulheres = somaAlturaMulheres / qtdMulheres;
        System.out.printf("Media das alturas das mulheres: %.2f%n",  mediaAlturaMulheres);
        System.out.printf("Numero de homens: %d\n", (pessoas.length - qtdMulheres));

        sc.close();

    }
}