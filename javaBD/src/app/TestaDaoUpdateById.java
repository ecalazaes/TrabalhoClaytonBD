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
        Contato contatoAtualizado = null;
        int id;

        while (true) {
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

            System.out.print("Deseja atualizar este contato (S/N)? ");
            char op = sc.nextLine().toUpperCase().charAt(0);
            if (op == 'S') {
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
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("OK, não vamos atualizar este contato.");
            }
        } else {
            System.out.println("Não existe contato com esse ID!");
        }
        retornarMenuPrincipal();
        sc.close();
    }
}
