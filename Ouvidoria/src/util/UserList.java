/**
 * The UserList class manages a list of users in the feedback system.
 * It provides functionality to add, search, and remove users.
 */
package util;

import entities.Aluno;
import entities.Funcionario;
import entities.Usuario;
import java.util.ArrayList;

public class UserList {
    private ArrayList<Usuario> UsersList;

    /**
     * Constructor for creating a new UserList object.
     * Initializes the list of users and adds a default administrator user.
     */
    public UserList(){
        UsersList = new ArrayList<>();
        UsersList.add(new Funcionario("adm", 0, "senhadoadm"));
    }

    /**
     * Adds a new student to the user list.
     * @param nome The name of the student
     * @param matricula The student ID
     * @param senha The password of the student
     */
    public void addAluno(String nome, int matricula, String senha){
        Aluno newStudent = new Aluno(nome, matricula, senha);
        UsersList.add(newStudent);
    }

    /**
     * Adds a new student to the user list.
     * @param newStudent The Aluno object representing the new student
     */
    public void addAluno(Aluno newStudent){
        UsersList.add(newStudent);
    }

    /**
     * Searches for a user based on the student ID.
     * @param matricula The student ID of the user to search for
     * @return The user object if found, null otherwise
     */
    public Usuario searchUser(int matricula){
        for (Usuario current : this.UsersList) {
            if (current.getMatricula() == matricula) {
                return current;
            }
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }

    /**
     * Removes a user from the user list based on the student ID.
     * @param matricula The student ID of the user to be removed
     */
    public void removeUser(int matricula) {
        this.UsersList.removeIf(current -> current.getMatricula() == matricula);
        System.out.println("Usuário removido com sucesso.");
    }

    /**
     * Retrieves the list of users.
     * @return The list of users
     */
    public ArrayList<Usuario> getUsersList() {
        return UsersList;
    }
}
