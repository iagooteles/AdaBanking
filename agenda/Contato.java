//package br.edu.grupo1.agenda;
//
//import br.edu.grupo1.banco.Conta;
//import br.edu.grupo1.entity.Pessoa;
//
//public class Contato extends Pessoa {
//
//    private int id;
//    private Conta conta;
//
//    public Contato( int id, String nome, String telefone, String email, Conta conta) {
//        super(nome, telefone, email);
//        this.id = id;
//        this.conta = conta;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    @Override
//    public String toString() {
//        return "ID: " + id + "| Nome: " + getNome() + " | telefone: " + getTelefone() + " | Email: " + getEmail() + "\n"
//                + "Agência Bancária: " + conta.getAgencia() + " | Número: " + conta.getNumero() + "\n"
//                + "_".repeat(40);
//    }
//}
