/**
 * The MenuFunctions class provides utility methods for displaying menus and handling user input.
 */
package util;

import entities.Aluno;
import java.util.Scanner;

public class MenuFunctions {
    /**
     * Displays the initial page menu.
     */
    public static void initialPage() {
        System.out.println("Escolha a opção:");
        System.out.println("1 - Fazer cadastro no sistema");
        System.out.println("2 - Fazer login");
        System.out.println("9 - Fechar sistema");
    }

    /**
     * Displays the registration page and prompts the user for input to create a new student.
     * @return A new Aluno object representing the registered student
     * @throws Exception If invalid input is provided
     */
    public static Aluno registerPage() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira os dados: Nome");
        String nome = sc.nextLine();
        System.out.println("Insira os dados: Senha");
        String senha = sc.nextLine();
        System.out.println("Insira os dados: Matrícula");
        int matricula = sc.nextInt();
        sc.nextLine();
        if (!nome.trim().isEmpty() && !senha.trim().isEmpty()) {
            return new Aluno(nome, matricula, senha);
        } else {
            throw new Exception("Nome ou senha inválidos.");
        }
    }

    /**
     * Displays the login page and prompts the user for input to perform login.
     * @return An array containing user's matricula and senha
     * @throws Exception If invalid input is provided
     */
    public static String[] loginPage() throws Exception {
        String[] dadosUsuario = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira sua matrícula:");
        dadosUsuario[0] = sc.nextLine();
        System.out.println("Insira sua senha:");
        dadosUsuario[1] = sc.nextLine();
        if (!dadosUsuario[0].trim().isEmpty() && !dadosUsuario[1].trim().isEmpty()) {
            return dadosUsuario;
        } else {
            throw new Exception("Matrícula ou senha inválidos.");
        }
    }

    /**
     * Displays the student menu.
     */
    public static void studentPage() {
        System.out.println("1 - Fazer novo feedback");
        System.out.println("2 - Ver feedbacks efetuados");
        System.out.println("8 - Deslogar");
        System.out.println("9 - Fechar sistema");
    }

    /**
     * Displays the administrator menu.
     */
    public static void admPage() {
        System.out.println("1 - Ver todos os feedbacks efetuados");
        System.out.println("2 - Deletar todos os feedbacks efetuados");
        System.out.println("3 - Deletar feedback específico");
        System.out.println("8 - Deslogar");
        System.out.println("9 - Fechar sistema");
    }

    /**
     * Prompts the user for input to create a new feedback.
     * @return An array containing tipo and manifestacao of the feedback
     */
    public static String[] createFeedback() {
        String[] dadosFeedback = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual tipo de feedback deseja fazer?");
        dadosFeedback[0] = sc.nextLine();
        System.out.println("Digite o feedback:");
        dadosFeedback[1] = sc.nextLine();
        return dadosFeedback;
    }
}
