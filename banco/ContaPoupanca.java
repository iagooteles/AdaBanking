package br.edu.grupo1.banco;

public class ContaPoupanca extends Conta {
    private int juros;

    public ContaPoupanca(String senha, int juros) {
        super(senha);
        this.juros = juros;
    }
}
