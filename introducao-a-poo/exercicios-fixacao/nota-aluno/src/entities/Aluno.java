package entities;

public class Aluno {

    public String nome;
    public double nota1;
    public double nota2;
    public double nota3;

    public double calcularMedia(){
        return nota1 + nota2 + nota3;
    }

    public void verificarAprovacao(double media){
        if (media >= 60) {
            System.out.println("\nFINAL GRADE = " + String.format("%.2f", media));
            System.out.println("PASS");
        } else {
            System.out.println("\nFINAL GRADE = " + String.format("%.2f", media));
            System.out.println("FAILED");
            System.out.println("MISSING " + String.format("%.2f", 60.0 - media) + " POINTS");
        }
    }

}
