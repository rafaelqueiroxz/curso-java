package model.entities;

import model.exceptios.DomainException;

public class Account {

    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Account() {
    }

    public Account(Integer numero, String titular, Double saldo, Double limiteSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public void deposito(Double valor) {
        this.saldo += valor;
    }

    public void saque(Double valor) {

        if (valor > limiteSaque) {
            throw new DomainException("Erro no saque: A tentativa de saque excede o limite diário.");
        }
        if (valor > saldo) {
            throw new DomainException("Erro no saque: Saldo insuficiente.");
        }

        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "Saldo disponível: $" + String.format("%.2f", saldo);
    }

}
