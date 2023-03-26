package application;

import entities.Feedback;
import util.FeedbackList;
import util.Auth;
import util.UserList;
import entities.Usuario;

import java.util.ArrayList;

public class Ouvidoria {

    FeedbackList feedbackList;
    UserList userList;
    Auth auth;
    public Ouvidoria(){
        this.feedbackList = new FeedbackList();
        this.userList = new UserList();
        this.auth = new Auth();
    }

    public void addManifestacao(String type, String manifestacao, int matriculaAutor){
        if (auth.getCurrentActive().getClass().getName().equals("Aluno"))
            feedbackList.addFeedback(type, manifestacao, matriculaAutor);
    }

    public void addAluno(String nome, int matricula, String senha) {
        userList.addAluno(nome, matricula, senha);
    }
    public void removeAllFeedbaks(){
        if (auth.getCurrentActive().getClass().getName().equals("Funcionario"))
            feedbackList.deleteAll();
    }
    public void removeFeedbaks(int idFeedback){
        if (auth.getCurrentActive().getClass().getName().equals("Funcionario"))
            feedbackList.deleteFeedbacks(idFeedback);
    }
    public void removeUser(int matricula){
        if (auth.getCurrentActive().getClass().getName().equals("Funcionario"))
            userList.removeUser(matricula);
    }

    public ArrayList<Feedback> getAllFeedback() {
        if (auth.getCurrentActive().getClass().getName().equals("Funcionario")){
            return feedbackList.all();
        }
        return null;
    }

    public UserList getUserList() {
        return userList;
    }


    public void login (int matricula, String senha){
        Usuario usuario = userList.searchUser(matricula);
        if (usuario.getSenha() == senha){
            auth.setCurrentActive(usuario);
        }
    }

    public ArrayList<Feedback> feebackUsuario(){
        if (auth.getCurrentActive().getClass().getName().equals("Aluno")){
            return feedbackList.userFeedbackByMatricula(auth.getCurrentActive().getMatricula());
        }
        return null;
    }
}
