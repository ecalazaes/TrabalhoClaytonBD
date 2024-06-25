package app;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

            while (true) {

                menu();
                if (sc.hasNextInt()) {
                    op = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("Por favor, digite um número válido.");
                    sc.nextLine();
                }
            }

            switch (op) {
                case 1:
                    TestaDaoInsereScanner.main(new String[]{});
                    break;
                case 2:
                    TestaDaoLista.main(new String[]{});
                    break;
                case 3:
                    TestaDaoListaById.main(new String[]{});
                    break;
                case 4:
                    TestaDaoListaByInicial.main(new String[]{});
                    break;
                case 5:
                    TestaDaoUpdateById.main(new String[]{});
                    break;
                case 6:
                    TestaDaoDeleteById.main(new String[]{});
                    break;
                case 7:
                    System.out.println("Saindo...");
                    sc.close();
                    break;
            }
    }

    private static void menu() {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1. Inserir contatos");
        System.out.println("2. Listar todos contatos");
        System.out.println("3. Listar contatos por ID");
        System.out.println("4. Listar contatos pela Inicial");
        System.out.println("5. Atualizar contatos");
        System.out.println("6. Deletar contatos");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção:  ");
    }

    public static void retornarMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        char op;
        do {
            System.out.print("Deseja voltar ao menu principal (S/N)?  ");
            op = sc.next().toUpperCase().charAt(0);

            if (op == 'S') {
                MainApp.main(new String[]{});
            } else if (op == 'N') {
                System.out.println("Saindo....");
                break;
            } else {
                System.out.println("Opção inválida. Tente Novamente.");
            }
        } while (op != 'S' && op != 'N');
        sc.close();
    }
}