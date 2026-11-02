/*
    Fazer um programa para ler um conjunto de N nomes de alunos,
    bem como as notas que eles tiraram no 1º e 2º semestres. Cada
    uma dessas informações deve ser armazenada em um vetor. Depois,
    imprimir os nomes dos alunos aprovados, considerando aprovados
    aqueles cuja média das notas seja maior ou igual a 6.0 (seis).

*/

package application;

import entities.Aluno;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos serão digitados? ");
        int n = sc.nextInt();

        Aluno[] alunos = new Aluno[n];

        for (int i = 0; i < alunos.length; i++) {
            sc.nextLine();
            System.out.printf("\nDigite o nome, a primeira e a segunda nota do %do aluno: \n", (i+1));
            String nome = sc.nextLine();
            float nota1 = sc.nextFloat();
            float nota2 = sc.nextFloat();

            alunos[i] = new Aluno(nome, nota1, nota2);
        }

        System.out.println("\nAlunos aprovados: ");
        for (Aluno aluno : alunos) {
            if ((aluno.getNota1() + aluno.getNota2()) / 2.0 >= 6.0) {
                System.out.println(aluno.getNome());
            }
        }


        sc.close();

    }
}