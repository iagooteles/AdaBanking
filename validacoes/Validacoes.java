package br.edu.grupo1.validacoes;

import br.edu.grupo1.entity.Usuario;

import java.util.List;

public class Validacoes {
    public static short validarCampoOpcao(String opt) throws Exception {
        try {
            return Short.parseShort(opt);
        } catch (NumberFormatException e) {
            throw new Exception("Opção inválida!");
        }
    }

    public static void validarCampoTelefone(String telefone, List<Usuario> contatos) throws Exception {
//        if (telefone.length() != 11) {
//            throw new Exception("Telefone inválido! Deve conter 11 caracteres.");
//        }

        if (!telefone.matches("\\d+")) {
            throw new Exception("Telefone deve conter apenas números.");
        }

        for (Usuario contato : contatos) {
            if (contato.getTelefone().equals(telefone)) {
                throw new Exception("Telefone já cadastrado!");
            }
        }
    }

    public static void validarCampoEmail(String email) throws Exception {
//        if (!email.contains("@") || !email.contains(".")) {
//            throw new Exception("Email inválido!");
//        }
        System.out.println("Campo validado!");
    }

}
