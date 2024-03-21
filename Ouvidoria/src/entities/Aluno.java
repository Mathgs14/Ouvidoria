/**
 * The Aluno class represents a student entity in the feedback system.
 * It extends the Usuario class.
 */
package entities;

public class Aluno extends Usuario {

    /**
     * Constructor for creating a new Aluno object.
     * @param nome The name of the student
     * @param matricula The student ID
     * @param senha The password of the student
     */
    public Aluno(String nome, int matricula, String senha) {
        super(nome, matricula, senha);
    }
}
