package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.Scanner;

import static app.MainApp.retornarMenuPrincipal;

public class TestaDaoInsereScanner {
    public static void main(String[] args) {
        Contato contato;
        Scanner sc = new Scanner(System.in);
        int qtdAddContato;

        while (true) {
            System.out.println();
            System.out.println("Escolhida opção 1 - Inserir contato(s).");
            System.out.print("Deseja adicionar quantos contatos? ");

            if (sc.hasNextInt()) {
                qtdAddContato = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Por favor, digite um número válido.");
                sc.nextLine();
            }
        }

        for (int i = 0; i < qtdAddContato; i++) {
            System.out.println();
            System.out.print("Insira o nome do " + (i + 1) + "° contato: ");
            String nome = sc.nextLine();

            System.out.print("Insira o email do " + (i + 1) + "° contato: ");
            String email = sc.nextLine();

            System.out.print("Insira o endereço do " + (i + 1) + "° contato: ");
            String endereco = sc.nextLine();

            contato = new Contato(nome, email, endereco);

            try {
                ContatoDao dao = new ContatoDao();
                dao.adiciona(contato);
                System.out.println("Contato [" + contato.getNome() + "] adicionado com sucesso!");
                System.out.println();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        retornarMenuPrincipal();
        sc.close();
    }
}
