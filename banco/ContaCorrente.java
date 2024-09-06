package br.edu.grupo1.banco;

public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(String senha, double limite) {
        super(senha);
        this.limite = limite;
    }

    public void aumentarLimite(double valor) {
        if (valor > 0) {
            limite += valor;
            System.out.println("Limite aumentado em R$" + valor + ". Novo limite: R$" + limite);
        } else {
            System.out.println("Valor inválido para aumento do limite.");
        }
    }

    public void diminuirLimite(double valor) {
        if (valor > 0 && valor <= limite) {
            limite -= valor;
            System.out.println("Limite diminuído em R$" + valor + ". Novo limite: R$" + limite);
        } else {
            System.out.println("Valor inválido para diminuir o limite.");
        }
    }

    public double consultarLimite() {
        return limite;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Limite: R$" + limite);
    }
}
