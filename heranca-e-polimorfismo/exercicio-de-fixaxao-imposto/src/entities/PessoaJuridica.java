package entities;

public class PessoaJuridica extends Contribuinte{

    private Integer numeroDeFuncionarios;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, Double receitaAnual, Integer numeroDeFuncionarios) {
        super(nome, receitaAnual);
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    public Integer getNumeroDeFuncionarios() {
        return numeroDeFuncionarios;
    }

    public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    @Override
    public double calcularImposto() {
        if (numeroDeFuncionarios <= 10) {
            return super.getReceitaAnual() * 0.16;
        } else {
            return super.getReceitaAnual() * 0.14;
        }
    }


}
