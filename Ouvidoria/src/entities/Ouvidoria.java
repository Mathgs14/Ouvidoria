package entities;


import java.util.ArrayList;
import util.Auth;
import util.FeedbackList;
import util.UserList;

public class Ouvidoria {
    FeedbackList feedbackList = new FeedbackList();
    UserList userList = new UserList();
    Auth auth = new Auth();

    public Ouvidoria() {
    }

    public boolean isLogged() {
        return this.auth.getCurrentActive() != null;
    }

    public String userType() {
        return this.isLogged() ? this.auth.getCurrentActive().getClass().getName() : null;
    }

    public void addManifestacao(String type, String manifestacao, int matriculaAutor) {
        if (this.isLogged()) {
            if (this.userType().equals("entities.Aluno")) {
                this.feedbackList.addFeedback(type, manifestacao, matriculaAutor);
            }

        }
    }

    public void addAluno(String nome, int matricula, String senha) {
        this.userList.addAluno(nome, matricula, senha);
    }

    public void addAluno(Aluno newStudent) {
        this.userList.addAluno(newStudent);
    }


    public void removeAllFeedbaks() {
        if (this.userType().equals("entities.Funcionario")) {
            this.feedbackList.deleteAll();
        }

    }

    public void removeFeedbaks(int idFeedback) {
        if (this.isLogged()) {
            if (this.userType().equals("entities.Funcionario")) {
                this.feedbackList.deleteFeedbacks(idFeedback);
            }

        }
    }

    public void removeUser(int matricula) {
        if (this.isLogged()) {
            if (this.userType().equals("entities.Funcionario")) {
                this.userList.removeUser(matricula);
            }

        }
    }

    public ArrayList<Feedback> getAllFeedback() {
        if (!this.isLogged()) {
            return null;
        } else {
            return this.userType().equals("entities.Funcionario") ? this.feedbackList.all() : null;
        }
    }

    public UserList getUserList() {
        return this.userList;
    }

    public void login(int matricula, String senha) {
        Usuario usuario = this.userList.searchUser(matricula);
        if (usuario.getSenha().equals(senha)) {
            this.auth.setCurrentActive(usuario);
        }

    }

    public ArrayList<Feedback> feebackUsuario() {
        if (!this.isLogged()) {
            return null;
        } else {
            return this.userType().equals("entities.Aluno") ? this.feedbackList.userFeedbackByMatricula(this.auth.getCurrentActive().getMatricula()) : null;
        }
    }

    public void printUserFeedback(int matricula) {
        this.feedbackList.printUserFeedback(matricula);
    }


    public void printAllFeedbacks() {
        this.feedbackList.printAllFeedbacks();
    }

    public void logOut() {
        if (this.isLogged()) {
            this.auth.setCurrentActive((Usuario)null);
        }
    }

    public Auth getAuth() {
        return this.auth;
    }
}
