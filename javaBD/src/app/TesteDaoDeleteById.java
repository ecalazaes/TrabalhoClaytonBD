package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static app.MainApp.retornarMenuPrincipal;

public class TesteDaoDeleteById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contato> contatos = null;
        Contato contato = null;
        int id = -1;

        while (true) {
            System.out.print("Qual ID deseja deletar? ");
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
            for (Contato contatoDeletar : contatos) {
                System.out.println();
                System.out.println("====================================================");
                System.out.println("Nome: " + contatoDeletar.getNome());
                System.out.println("Email: " + contatoDeletar.getEmail());
                System.out.println("Endereço: " + contatoDeletar.getEndereco());
                System.out.println("====================================================");
                System.out.println();
            }

            System.out.print("Deseja deletar este contato (S/N)? ");
            char op = sc.nextLine().toUpperCase().charAt(0);
            if (op == 'S') {
                try {
                    ContatoDao dao = new ContatoDao();
                    dao.deleteById(id, contato);
                    System.out.println("Contato deletado com sucesso!");
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
