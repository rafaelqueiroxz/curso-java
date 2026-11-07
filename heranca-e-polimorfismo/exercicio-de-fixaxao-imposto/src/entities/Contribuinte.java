package entities;

public abstract class Contribuinte {

    private String nome;
    private Double receitaAnual;

    public Contribuinte() {
    }

    public Contribuinte(String nome, Double receitaAnual) {
        this.nome = nome;
        this.receitaAnual = receitaAnual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getReceitaAnual() {
        return receitaAnual;
    }

    public void setReceitaAnual(Double receitaAnual) {
        this.receitaAnual = receitaAnual;
    }

    public abstract double calcularImposto();

    public String toString() {
        return nome + ": $ " + String.format("%.2f", calcularImposto());
    }

}
