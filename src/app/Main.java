package app;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean encerrar = true;

        while (encerrar) {
            int optio = menu();
            switch (optio) {
                case 1:
                    escada();
                    break;
                case 2:
                    senha();
                    break;
                case 3:
                    anagrama();
                    break;
                case 0:
                    encerrar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static int menu() {
        limpaConsole();
        System.out.print("\t\t\t\tQuestões\n\n\n\n");
        System.out.print("\t1 - Escada\n");
        System.out.print("\t2 - Senha\n");
        System.out.print("\t3 - Anagrama\n");
        System.out.print("\t0 - Sair\n");

        return input.nextInt();
    }

    public static void escada() {
        do {
            limpaConsole();
            System.out.print("\t\t\t\tEscada\n\n\n\n");

            System.out.print("Tamanho da escada: ");
            int tamanho = input.nextInt();
            System.out.println(Utils.escada(tamanho));
        } while (!sair());
    }

    public static void senha() {
        do {
            limpaConsole();
            System.out.print("\t\t\t\tSenha\n\n\n\n");

            System.out.print("Digite uma senha: ");
            String senha = input.next();
            System.out.println(Utils.senhaForte(senha));
        } while (!sair());
    }

    public static void anagrama() {
        do {
            limpaConsole();
            System.out.print("\t\t\t\tAnagrama\n\n\n\n");

            System.out.print("Digite uma palavra qualquer: ");
            String palavra = input.next();
            System.out.println(Utils.anagramas(palavra));
        } while (!sair());
    }

    public static boolean sair() {
        System.out.println("Sair? (s/n)");
        String resposta = input.next();
        return resposta.compareToIgnoreCase("s") == 0;
    }

    public static void limpaConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
