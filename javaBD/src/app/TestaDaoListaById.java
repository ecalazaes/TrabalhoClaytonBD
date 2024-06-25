package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static app.MainApp.retornarMenuPrincipal;

public class TestaDaoListaById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contato> contatos = null;
        int id;

        while (true) {
            System.out.println();
            System.out.println("Escolhida opção 3 - Listar contato por ID.");
            System.out.print("Deseja buscar contato com qual ID? ");

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
                System.out.println();
            }

        } else {
            System.out.println("Não existe contato com esse ID!");
        }
        retornarMenuPrincipal();
        sc.close();
    }
}
