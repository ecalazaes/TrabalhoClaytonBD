package app;

import model.Contato;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean rodando = true;

        do {
            menu();
            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    TestaDaoInsereScanner.main(new String[]{});
                    rodando = false;
                    break;
                case 2:
                    TestaDaoLista.main(new String[]{});
                    rodando = false;
                    break;
                case 3:
                    TestaDaoListaById.main(new String[]{});
                    rodando = false;
                    break;
                case 4:
                     TesteDaoListaByInicial.main(new String[]{});
                     rodando = false;
                    break;
                case 5:
                     TestaDaoUpdateById.main(new String[]{});
                    rodando = false;
                    break;
                case 6:
                    TesteDaoDeleteById.main(new String[]{});
                    rodando = false;
                    break;
                case 7:
                    System.out.println("Saindo...");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente Novamente.");
                    break;
            }
        } while (rodando);

        sc.close();
    }

    private static void menu() {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1. Inserir contatos");
        System.out.println("2. Buscar todos contatos");
        System.out.println("3. Buscar contatos por ID");
        System.out.println("4. Buscar pela Inicial contatos");
        System.out.println("5. Atualizar contatos");
        System.out.println("6. Deletar contatos");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção:  ");
    }

    public static void retornarMenuPrincipal(){
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

