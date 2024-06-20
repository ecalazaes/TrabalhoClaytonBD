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

        System.out.print("Qual ID deseja atualizar? ");
        int id = Integer.parseInt(sc.nextLine());

        try {
            ContatoDao dao = new ContatoDao();
            contatos = dao.getListaById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (contatos != null && !contatos.isEmpty()) {
            for (Contato contato : contatos ) {
                System.out.println();
                System.out.println("====================================================");
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println("====================================================");
                System.out.println();
            }

            System.out.println("Por favor inserir novos dados:");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Endereco: ");
            String endereco = sc.nextLine();

            Contato contato = new Contato(nome, email, endereco);

            try {
                ContatoDao dao = new ContatoDao();
                dao.updateById(id, contato);
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
