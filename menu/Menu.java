package br.edu.grupo1.menu;

import br.edu.grupo1.entity.Usuario;

import java.util.Scanner;

import static br.edu.grupo1.menu.Apresentacao.*;
import static br.edu.grupo1.servicos.Servicos.*;
import static br.edu.grupo1.validacoes.Validacoes.validarCampoOpcao;

public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        short op = -1;

        adicionarContatoPelosistema();

        do {
            mostrarMenu();
            try {
                op = validarCampoOpcao(scanner.nextLine());
                direcionarOpcao(op);
            } catch (Exception e) {
                System.out.println("Erro: " + e);
                continue;
            }
        } while (op != 0);
    }

    public static void direcionarOpcao(short op) {
        switch (op) {
            case 1:
                adicionarContato();
                break;
            case 2:
                listarContatos();
                break;
            case 3:
                editarContato();
                break;
            case 4:
                removerContato();
                break;
            case 5:
                Usuario usuario = validarUsuario();
                if (usuario != null) acessarContaBancaria(usuario);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void acessarContaBancaria(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        short opcao = -1;

        do {
            mostrarMenuContaBancaria();

            try {
                opcao = validarCampoOpcao(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        usuario.getConta().exibirInformacoes();
                        break;
                    case 2:
                        usuario.getConta().depositar();
                        break;
                    case 3:
                        usuario.getConta().sacar();
                        break;
                    case 4:
                        usuario.getConta();
                        break;
                    case 0:
                        System.out.println("Saindo da sua conta...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }
}
