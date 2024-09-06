package br.edu.grupo1.servicos;

import br.edu.grupo1.banco.Conta;
import br.edu.grupo1.entity.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static br.edu.grupo1.menu.Apresentacao.mostrarCabecalhoContatos;
import static br.edu.grupo1.validacoes.Validacoes.validarCampoEmail;
import static br.edu.grupo1.validacoes.Validacoes.validarCampoTelefone;

public class Servicos {
    static Scanner scanner = new Scanner(System.in);
    static List<Usuario> usuarios = new ArrayList<>();
    static short contador = 0;


    public static void adicionarContatoPelosistema() {
        adicionarContato("Alice Silva", "11987654321", "alice.silva@example.com", new Conta("1234"));
        adicionarContato("Bruno Santos", "21987654321", "bruno.santos@example.com", new Conta("1234"));
        adicionarContato("Carla Oliveira", "31987654321", "carla.oliveira@example.com", new Conta("1234"));
        adicionarContato("David Lima", "41987654321", "david.lima@example.com", new Conta("1234"));
        adicionarContato("Eva Costa", "51987654321", "eva.costa@example.com", new Conta("1234"));
    }

    public static void adicionarContato(String nome, String telefone, String email, Conta conta) {

        Usuario novoContato = new Usuario(++contador, nome, telefone, email, conta);
        usuarios.add(novoContato);
        System.out.println("Contato adicionado com sucesso: " + novoContato);
    }

    public static void adicionarContato() {
        System.out.println("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do contato (11 caracteres) ");
        String telefone = scanner.nextLine();

        try {
            // telefone não pode ser repetido?? //
            validarCampoTelefone(telefone, usuarios);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return;
        }

        System.out.println("Digite o email do contato (exemplo@qualquer.com): ");
        String email = scanner.nextLine();

        try {
            validarCampoEmail(email);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return;
        }


        System.out.println("Digite a sua senha do contato: ");
        String senha = scanner.nextLine();

        usuarios.add(new Usuario(++contador, nome, telefone, email, new Conta(senha)));
        System.out.println("Contato adicionado com sucesso!");
        listarContatos();
    }

    public static void listarContatos() {
        if (usuarios.isEmpty()) {
            System.out.println("A lista de contatos está vazia.");
            return;
        }

        mostrarCabecalhoContatos();

        for (Usuario usuario: usuarios) {
            System.out.println(usuario);
        }

    }

    public static void editarContato() {
        System.out.println("Digite o ID do contato que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Usuario contatoParaEditar = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                contatoParaEditar = usuario;
                break;
            }
        }

        if (contatoParaEditar == null) {
            System.out.println("Contato com ID " + id + " não encontrado.");
            return;
        }

        System.out.println("O que deseja editar?");
        System.out.println("1. Nome");
        System.out.println("2. Telefone");
        System.out.println("3. Email");
        System.out.println("Digite o número da opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                contatoParaEditar.setNome(novoNome);
                System.out.println("Nome atualizado com sucesso.");
                break;

            case 2:
                System.out.println("Digite o novo telefone (11 caracteres): ");
                String novoTelefone = scanner.nextLine();
                try {
                    validarCampoTelefone(novoTelefone, usuarios);
                    contatoParaEditar.setTelefone(novoTelefone);
                    System.out.println("Telefone atualizado com sucesso.");
                } catch (Exception e) {
                    System.out.println("Erro ao atualizar telefone: " + e.getMessage());
                }
                break;

            case 3:
                System.out.println("Digite o novo email: ");
                String novoEmail = scanner.next();
                try {
                    validarCampoEmail(novoEmail); // Verifica se o email é válido
                    contatoParaEditar.setEmail(novoEmail);
                    System.out.println("Email atualizado com sucesso.");
                } catch (Exception e) {
                    System.out.println("Erro ao atualizar email: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    public static void removerContato() {
        Scanner scanner = new Scanner(System.in);

        listarContatos();

        System.out.println("Digite o ID do contato que deseja remover: ");
        int id = scanner.nextInt();

        boolean encontrado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                usuarios.remove(i);
                System.out.println("Contato removido com sucesso.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contato com ID " + id + " não encontrado.");
        }
    }

    public static Usuario validarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = buscarUsuarioPorId(id);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (usuario.getConta().getSenha().equals(senha)) {
            System.out.println("Usuário validado com sucesso.");
            return usuario;
        } else {
            System.out.println("Senha incorreta.");
        }

        return null;
    }

    private static Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }


}
