package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static app.MainApp.retornarMenuPrincipal;

public class TestaDaoUpdateById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contato> contatos = null;
        Contato contatoAtualizado;
        int id;

        while (true) {
            System.out.println();
            System.out.println("Escolhida opção 5 - Atualizar contato.");
            System.out.print("Qual ID deseja atualizar? ");

            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Por favor, digite um número válido.");
                sc.nextLine();
            }
        }

        try {
            ContatoDao dao = new ContatoDao();
            contatos = dao.getListaById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (contatos != null && !contatos.isEmpty()) {
            System.out.println();
            System.out.println("Contato com id [" + id + "] foi encontrado.");
            for (Contato contato : contatos) {
                System.out.println("====================================================");
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("====================================================");
            }

            System.out.println();
            char op;
            do {
                System.out.print("Deseja atualizar este contato (S/N)? ");
                op = sc.nextLine().toUpperCase().charAt(0);
                if (op == 'S') {
                    System.out.println();
                    System.out.println("Por favor, insira os novos dados:");

                    System.out.print("Novo Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Novo Email: ");
                    String email = sc.nextLine();

                    System.out.print("Novo Endereço: ");
                    String endereco = sc.nextLine();

                    contatoAtualizado = new Contato(nome, email, endereco);

                    try {
                        ContatoDao dao = new ContatoDao();
                        dao.updateById(id, contatoAtualizado);
                        System.out.println("Contato atualizado com sucesso!");
                        System.out.println();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else if (op == 'N') {
                    System.out.println("Ok, não vamos atualizar o contato.");
                    System.out.println();
                } else {
                    System.out.println("Opção inválida. Digite (S) ou (N).");
                }
            } while (op != 'S' && op != 'N');
        } else {
            System.out.println("Não existe contato com esse ID!");
        }

        retornarMenuPrincipal();
        sc.close();
    }
}
