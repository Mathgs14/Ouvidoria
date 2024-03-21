/**
 * The Ouvidoria class represents a feedback system.
 * It manages user authentication, feedback submission, and user roles.
 */
package entities;

import java.util.ArrayList;
import util.Auth;
import util.FeedbackList;
import util.UserList;

public class Ouvidoria {
    private FeedbackList feedbackList = new FeedbackList();
    private UserList userList = new UserList();
    private Auth auth = new Auth();

    /**
     * Default constructor for creating a new Ouvidoria object.
     */
    public Ouvidoria() {
    }

    /**
     * Checks if a user is currently logged in.
     * @return true if a user is logged in, false otherwise
     */
    public boolean isLogged() {
        return this.auth.getCurrentActive() != null;
    }

    /**
     * Retrieves the type of the currently logged-in user.
     * @return The type of the currently logged-in user
     */
    public String userType() {
        return this.isLogged() ? this.auth.getCurrentActive().getClass().getName() : null;
    }

    /**
     * Adds a new feedback submission.
     * @param type The type/category of feedback
     * @param manifestacao The content of the feedback
     * @param matriculaAutor The student ID of the author
     */
    public void addManifestacao(String type, String manifestacao, int matriculaAutor) {
        if (this.isLogged()) {
            if (this.userType().equals("entities.Aluno")) {
                this.feedbackList.addFeedback(type, manifestacao, matriculaAutor);
            }
        }
    }

    /**
     * Adds a new student to the user list.
     * @param nome The name of the student
     * @param matricula The student ID
     * @param senha The password of the student
     */
    public void addAluno(String nome, int matricula, String senha) {
        this.userList.addAluno(nome, matricula, senha);
    }

    /**
     * Adds a new student to the user list.
     * @param newStudent The Aluno object representing the new student
     */
    public void addAluno(Aluno newStudent) {
        this.userList.addAluno(newStudent);
    }

    /**
     * Removes all feedback submissions (for administrators only).
     */
    public void removeAllFeedbaks() {
        if (this.userType().equals("entities.Funcionario")) {
            this.feedbackList.deleteAll();
        }
    }

    /**
     * Removes a specific feedback submission (for administrators only).
     * @param idFeedback The unique ID of the feedback to be removed
     */
    public void removeFeedbaks(int idFeedback) {
        if (this.isLogged()) {
            if (this.userType().equals("entities.Funcionario")) {
                this.feedbackList.deleteFeedbacks(idFeedback);
            }
        }
    }

    /**
     * Removes a user from the user list (for administrators only).
     * @param matricula The student ID of the user to be removed
     */
    public void removeUser(int matricula) {
        if (this.isLogged()) {
            if (this.userType().equals("entities.Funcionario")) {
                this.userList.removeUser(matricula);
            }
        }
    }

    /**
     * Retrieves all feedback submissions (for administrators only).
     * @return An ArrayList containing all feedback submissions
     */
    public ArrayList<Feedback> getAllFeedback() {
        if (!this.isLogged()) {
            return null;
        } else {
            return this.userType().equals("entities.Funcionario") ? this.feedbackList.all() : null;
        }
    }

    /**
     * Retrieves the user list.
     * @return The UserList object containing all users
     */
    public UserList getUserList() {
        return this.userList;
    }

    /**
     * Performs user login.
     * @param matricula The student ID of the user
     * @param senha The password of the user
     */
    public void login(int matricula, String senha) {
        Usuario usuario = this.userList.searchUser(matricula);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            this.auth.setCurrentActive(usuario);
        }
    }

    /**
     * Retrieves feedback submissions submitted by the current user (for students only).
     * @return An ArrayList containing feedback submissions submitted by the current user
     */
    public ArrayList<Feedback> feebackUsuario() {
        if (!this.isLogged()) {
            return null;
        } else {
            return this.userType().equals("entities.Aluno") ? this.feedbackList.userFeedbackByMatricula(this.auth.getCurrentActive().getMatricula()) : null;
        }
    }

    /**
     * Prints feedback submissions submitted by a specific user.
     * @param matricula The student ID of the user whose feedback submissions are to be printed
     */
    public void printUserFeedback(int matricula) {
        this.feedbackList.printUserFeedback(matricula);
    }

    /**
     * Prints all feedback submissions (for administrators only).
     */
    public void printAllFeedbacks() {
        this.feedbackList.printAllFeedbacks();
    }

    /**
     * Logs out the current user.
     */
    public void logOut() {
        if (this.isLogged()) {
            this.auth.setCurrentActive(null);
        }
    }

    /**
     * Retrieves the authentication object.
     * @return The Auth object used for user authentication
     */
    public Auth getAuth() {
        return this.auth;
    }
}
