package app;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;

import static app.MainApp.retornarMenuPrincipal;

public class TestaDaoLista {
    public static void main(String[] args) {
        List<Contato> contatos;

        try {
            ContatoDao dao = new ContatoDao();
            contatos = dao.getLista();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (contatos != null && !contatos.isEmpty()) {
            System.out.println();
            System.out.println("Escolhida opção 2 - Listar de contato(s).");
            System.out.println("A lista de contatos possui " + contatos.size() + " contatos.");
            for (Contato contato : contatos) {
                System.out.println("====================================================");
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereço: " + contato.getEndereco());

            }
            System.out.println();
        } else {
            System.out.println("Lista de contatos está vazia!");
        }
        retornarMenuPrincipal();
    }
}
