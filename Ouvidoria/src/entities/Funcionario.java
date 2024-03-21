/**
 * The Funcionario class represents an employee entity in the feedback system.
 * It extends the Usuario class.
 */
package entities;

public class Funcionario extends Usuario {

    /**
     * Constructor for creating a new Funcionario object.
     * @param nome The name of the employee
     * @param matricula The employee ID
     * @param senha The password of the employee
     */
    public Funcionario(String nome, int matricula, String senha) {
        super(nome, matricula, senha);
    }

}
