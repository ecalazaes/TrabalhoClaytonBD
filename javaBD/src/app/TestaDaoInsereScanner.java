package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.Scanner;

import static app.MainApp.retornarMenuPrincipal;

public class TestaDaoInsereScanner {
    public static void main(String[] args) {
        Contato contato = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("Deseje adicionar quantos contatos? ");
        int opcao = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < opcao; i++) {
            System.out.print("Insira o nome do contato [" +(i+1)+ "]: ");
            String nome = sc.nextLine();

            System.out.print("Insira o Email do contato [" +(i+1)+ "]: ");
            String email = sc.nextLine();

            System.out.print("Insira o Endereço contato [" +(i+1)+ "]: ");
            String endereco = sc.nextLine();

            System.out.println();

            contato  = new Contato(nome, email, endereco );

            try {
                ContatoDao dao = new ContatoDao();
                dao.adiciona(contato);
                System.out.println("Contato " + (i+1) + " adicionado com sucesso!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        retornarMenuPrincipal();
        sc.close();
    }
}