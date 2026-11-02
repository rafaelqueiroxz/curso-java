package application;

import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos funcionários serão cadastrados? ");
        int n = sc.nextInt();

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nFuncionario " + (i + 1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Salario: ");
            float salario = sc.nextFloat();

            funcionarios.add(new Funcionario(id, nome, salario));

        }

        System.out.print("\nEntre com o id do funcionário que receberá o aumento: ");
        int idAumento = sc.nextInt();

        Boolean funcionarioExiste = funcionarios.stream()
                        .anyMatch(f -> f.getId() == idAumento);
        if (!funcionarioExiste) {
            System.out.println("Funcionário não existente!");
        } else {
            System.out.print("Digite o percentual que será acrescido no salário deste funcionário: ");
            float percentualAumento = sc.nextFloat();
            float novoSalario = funcionarios
                    .stream()
                    .filter(f -> f.getId() == idAumento)
                    .findFirst()
                    .get()
                    .getSalario();
            novoSalario += (novoSalario / 100) * percentualAumento;
            for (Funcionario f : funcionarios) {
                if (f.getId() == idAumento) {
                    f.setSalario(novoSalario);
                }
            }
        }

        System.out.println("\nLista de Funcionários\n");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        sc.close();

    }
}