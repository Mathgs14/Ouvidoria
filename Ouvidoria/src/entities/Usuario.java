/**
 * The Usuario class represents a user in the feedback system.
 * It serves as a base class for other user types such as Aluno and Funcionario.
 */
package entities;

public class Usuario {
    private String nome;
    private String senha;
    private int matricula;

    /**
     * Constructor for creating a new Usuario object.
     * @param nome The name of the user
     * @param matricula The user's identification number
     * @param senha The password of the user
     */
    public Usuario(String nome, int matricula, String senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }

    /**
     * Getter method for retrieving the user's name.
     * @return The name of the user
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter method for setting the user's name.
     * @param nome The name of the user
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter method for retrieving the user's identification number.
     * @return The user's identification number
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Setter method for setting the user's identification number.
     * @param matricula The user's identification number
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter method for retrieving the user's password.
     * @return The password of the user
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Setter method for setting the user's password.
     * @param senha The password of the user
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
