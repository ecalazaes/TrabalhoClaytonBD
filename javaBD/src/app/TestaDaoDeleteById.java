package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static app.MainApp.retornarMenuPrincipal;

public class TestaDaoDeleteById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contato> contatos = null;
        Contato contato = null;
        int id;

        while (true) {
            System.out.println();
            System.out.println("Escolhida opção 6 - Deletar contato(s)");
            System.out.print("Qual ID deseja deletar? ");

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
            for (Contato contatoDeletar : contatos) {
                System.out.println("====================================================");
                System.out.println("Nome: " + contatoDeletar.getNome());
                System.out.println("Email: " + contatoDeletar.getEmail());
                System.out.println("Endereço: " + contatoDeletar.getEndereco());
                System.out.println("====================================================");
            }
            System.out.println();

            System.out.print("Deseja deletar este contato (S/N)? ");
            char op = sc.nextLine().toUpperCase().charAt(0);
            if (op == 'S') {
                try {
                    ContatoDao dao = new ContatoDao();
                    dao.deleteById(id, contato);
                    System.out.println("Contato deletado com sucesso!");
                    System.out.println();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Ok, não vamos deletar o contato.");
            }
        } else {
            System.out.println("Contato não encontrado!");
        }
        retornarMenuPrincipal();
        sc.close();
    }
}
