package br.edu.grupo1.entity;

import br.edu.grupo1.banco.Conta;

public class Usuario extends Pessoa {
    private int id;
    private Conta conta;

    public Usuario( int id, String nome, String telefone, String email, Conta conta) {
        super(nome, telefone, email);
        this.id = id;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "ID: " + id + "| Nome: " + getNome() + " | telefone: " + getTelefone() + " | Email: " + getEmail() + "\n"
                + "Agência Bancária: " + conta.getAgencia() + " | Número: " + conta.getNumero() + "\n"
                + "_".repeat(40);
    }
}
