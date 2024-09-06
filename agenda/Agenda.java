package br.edu.grupo1.agenda;

import br.edu.grupo1.entity.Pessoa;
import br.edu.grupo1.entity.Usuario;

import java.util.List;

public class Agenda {
    private List<Usuario> contatos;

    public Agenda(List<Usuario> contatos) {
        this.contatos = contatos;
    }

    public void adicionarPessoas(Usuario contato) {
        contatos.add(contato);
    }
}
