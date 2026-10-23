package entities;

public class ContaBancaria {

    private int numeroConta;
    private String nomeTitular;
    private double saldo;

    private static final double TAXA = 5.00;

    public ContaBancaria(int numeroConta, String nomeTitular, double depositoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        depositar(depositoInicial);
    }

    public ContaBancaria(int numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double deposito) {
        this.saldo += deposito;
    }

    public void sacar(double saque) {
        this.saldo -= saque + TAXA;
    }

    public String toString() {
        return "Dados da Conta: Conta " + numeroConta + ", Titular: " + nomeTitular
                + ", Saldo: R$ " + String.format("%.2f", saldo);
    }

}
