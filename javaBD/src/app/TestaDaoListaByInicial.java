package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static app.MainApp.retornarMenuPrincipal;

public class TestaDaoListaByInicial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contato> contatos = null;

        System.out.println();
        System.out.println("Escolhida opção 4 - Listar contato(s) pela inicial.");
        System.out.print("Deseja buscar contato com qual inicial? ");
        char inicial = sc.next().toUpperCase().charAt(0);

        try {
            ContatoDao dao = new ContatoDao();
            contatos = dao.getListaByInicial(inicial);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (contatos != null && !contatos.isEmpty()) {
            System.out.println();
            System.out.println("Lista de contatos com a inicial [" + inicial + "].");
            for (Contato contato : contatos) {
                System.out.println("====================================================");
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
            }
            System.out.println();

        } else {
            System.out.println("Não existe contato com essa inicial!");
        }

        retornarMenuPrincipal();
        sc.close();
    }
}
