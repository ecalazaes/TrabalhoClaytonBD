package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static app.MainApp.retornarMenuPrincipal;

public class TesteDaoListaByInicial {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        List<Contato> contatos = null;

        System.out.print("Deseja buscar contato inicial com qual letra? ");
        String inicial = sc.nextLine();

        try {
            ContatoDao dao = new ContatoDao();
            contatos = dao.getListaByInicial(inicial);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (contatos != null && !contatos.isEmpty()) {
            for (Contato contato : contatos ) {
                System.out.println("====================================================");
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());
                System.out.println();
            }

        } else {
            System.out.println("Não existe contato com essa inicial!");
        }

        retornarMenuPrincipal();
        sc.close();
    }
}
