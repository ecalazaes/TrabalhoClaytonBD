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
        int id = -1;

        while (true) {
            System.out.print("Qual ID deseja atualizar? ");
            String opcao = sc.nextLine();

            if (opcao.matches("\\d+")) {
                id = Integer.parseInt(opcao);
                break;
            } else {
                System.out.println("Por favor, digite um número válido.");
            }
        }

        try {
            ContatoDao dao = new ContatoDao();
            contatos = dao.getListaById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (contatos != null && !contatos.isEmpty()) {
            for (Contato contato : contatos) {
                System.out.println();
                System.out.println("====================================================");
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("====================================================");
                System.out.println();
            }

            System.out.println("Por favor, insira os novos dados:");

            System.out.print("Novo Nome: ");
            String nome = sc.nextLine();

            System.out.print("Novo Email: ");
            String email = sc.nextLine();

            System.out.print("Novo Endereço: ");
            String endereco = sc.nextLine();

            Contato contatoAtualizado = new Contato(nome, email, endereco);

            try {
                ContatoDao dao = new ContatoDao();
                dao.updateById(id, contatoAtualizado);
                System.out.println("Contato atualizado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Não existe contato com esse ID!");
        }

        retornarMenuPrincipal();
        sc.close();
    }
}
