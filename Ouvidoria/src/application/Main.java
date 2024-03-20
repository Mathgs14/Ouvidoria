package application;

import java.util.Scanner;

import entities.Aluno;
import entities.Ouvidoria;
import entities.Usuario;
import util.MenuFunctions;

public class Main {
    public static void main(String[] args) {
        Ouvidoria ouvidoria = new Ouvidoria();

        int escolha = 0;
        while (escolha != 9){
            if(!ouvidoria.isLogged()){

                escolha = authPage(ouvidoria);
            }
            else{

                if(ouvidoria.userType().equals("entities.Funcionario")){
                    escolha = menuAdm(ouvidoria);
                }else{
                    escolha = menuAluno(ouvidoria, ouvidoria.getAuth().getCurrentActive());
                }
            }
        }

    }

    public static int authPage(Ouvidoria ouvidoria) {
        int escolha;
        Scanner sc = new Scanner(System.in);
        MenuFunctions.initialPage();

        escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> {
                try {
                    Aluno novoUsuario = MenuFunctions.registerPage();
                    ouvidoria.addAluno(novoUsuario);
                }
                catch (Exception exception){
                    System.out.println("Algum dos dados fornecidos não é válido");
                }
            }

            case 2 ->{
                try{
                    String[] dadosUsuario = MenuFunctions.loginPage();
                    ouvidoria.login(Integer.parseInt(dadosUsuario[0]), dadosUsuario[1]);
                }catch (Exception exception){
                    System.out.println("Algum dos dados fornecidos não é válido");
                }
            }

            case 9 -> {
            }

            default -> System.out.println("escolha inválida");
        }

        return escolha;
    }


    public static int menuAdm(Ouvidoria ouvidoria){
        int escolha;
        Scanner sc = new Scanner(System.in);
        MenuFunctions.admPage();
        escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> ouvidoria.printAllFeedbacks();

            case 2 -> ouvidoria.removeAllFeedbaks();

            case 3 -> {
                ouvidoria.printAllFeedbacks();
                int feedbackId = sc.nextInt();
                ouvidoria.removeFeedbaks(feedbackId);
            }

            case 8 -> ouvidoria.logOut();

            case 9 ->{}



            default -> System.out.println("escolha inválida");
        }

        return escolha;
    }

    public static int menuAluno(Ouvidoria ouvidoria, Usuario currentActive){
        int escolha;
        Scanner sc = new Scanner(System.in);
        MenuFunctions.studentPage();
        escolha = sc.nextInt();

        switch (escolha) {
            case 1 -> {
                String[] novoFeedback = MenuFunctions.createFeedback();
                ouvidoria.addManifestacao(novoFeedback[0], novoFeedback[1], currentActive.getMatricula());
            }

            case 2 -> ouvidoria.printUserFeedback(currentActive.getMatricula());


            case 8 -> ouvidoria.logOut();

            case 9 -> {}

            default -> System.out.println("escolha inválida");
        }

        return escolha; 
    }

}
