package util;

import entities.Aluno;
import java.util.Scanner;

public class MenuFunctions {
    public MenuFunctions() {
    }

    public static void initialPage() {
        System.out.println("Escolha a opção");
        System.out.println("1 - Fazer cadastro no sistema");
        System.out.println("2 - Fazer login");
        System.out.println("9 - Fechar sistema");
    }

    public static Aluno registerPage() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("insira os dados: Nome");
        String nome = sc.nextLine();
        System.out.println("insira os dados: Senha");
        String senha = sc.nextLine();
        System.out.println("insira os dados: Matricula");
        int matricula = sc.nextInt();
        sc.nextLine();
        if (!nome.equals("") && !senha.equals("")) {
            if (!nome.equals(" ") && !senha.equals(" ")) {
                return new Aluno(nome, matricula, senha);
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    public static String[] loginPage() throws Exception {
        String[] dadosUsuario = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira sua matricula");
        dadosUsuario[0] = sc.nextLine();
        System.out.println("Insira sua senha:");
        dadosUsuario[1] = sc.nextLine();
        if (!dadosUsuario[0].equals("") && !dadosUsuario[1].equals("")) {
            if (!dadosUsuario[0].equals(" ") && !dadosUsuario[1].equals(" ")) {
                return dadosUsuario;
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    public static void studentPage() {
        System.out.println("1 - Fazer novo feedback");
        System.out.println("2 - Ver feedbacks efetuados");
        System.out.println("8 - Deslogar");
        System.out.println("9 - Fechar sistema");
    }

    public static void admPage() {
        System.out.println("1 - Ver todos os feedbacks efetuados");
        System.out.println("2 - Deletar todos os feedbacks efetuados");
        System.out.println("3 - Deletar feedback especifico");
        System.out.println("8 - Deslogar");
        System.out.println("9 - Fechar sistema");
    }

    public static String[] createFeedback() {
        String[] dadosFeedback = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual tipo de feedback deseja fazer?");
        dadosFeedback[0] = sc.nextLine();
        System.out.println("Digite o feedback");
        dadosFeedback[1] = sc.nextLine();
        return dadosFeedback;
    }
}
