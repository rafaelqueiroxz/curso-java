/*

    Fazer um programa para ler um conjunto de nomes de pessoas
    e suas respectivas idades. Os nomes devem ser armazenados
    em um vetor, e as idades em um outro vetor. Depois, mostrar
    na tela o nome da pessoa mais velha.

*/

package application;

import entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas você vai digitar? ");
        int n = sc.nextInt();

        Pessoa[] pessoas = new Pessoa[n];

        for (int i = 0; i < pessoas.length; i++) {
            sc.nextLine();
            System.out.printf("\nDados da %da pessoa: \n", (i+1));
            System.out.printf("Nome: ");
            String nome = sc.nextLine();
            System.out.printf("Idade: ");
            int idade = sc.nextInt();

            pessoas[i] = new Pessoa(nome, idade);
        }

        int posicaoMaisVelha = 0;
        for (int i = 1; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() > pessoas[posicaoMaisVelha].getIdade()) {
                posicaoMaisVelha = i;
            }
        }

        System.out.println("\nPESSOA MAIS VELHA: " + pessoas[posicaoMaisVelha].getNome());

        sc.close();

    }
}