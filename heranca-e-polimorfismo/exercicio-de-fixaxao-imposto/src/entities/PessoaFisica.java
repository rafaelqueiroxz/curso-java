package entities;

public class PessoaFisica extends Contribuinte{

    private Double despesasMedicas;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, Double receitaAnual, Double despesasMedicas) {
        super(nome, receitaAnual);
        this.despesasMedicas = despesasMedicas;
    }

    public Double getDespesasMedicas() {
        return despesasMedicas;
    }

    public void setDespesasMedicas(Double despesasMedicas) {
        this.despesasMedicas = despesasMedicas;
    }

    @Override
    public double calcularImposto() {
        if (super.getReceitaAnual() < 20000.00) {
            return super.getReceitaAnual() * 0.15 - despesasMedicas * 0.5;
        } else {
            return super.getReceitaAnual() * 0.25 - despesasMedicas * 0.5;
        }
    }

}
