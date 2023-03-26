package util;

import entities.Aluno;
import entities.Funcionario;
import entities.Usuario;

import java.util.ArrayList;

public class UserList {
    ArrayList<Usuario> UsersList;

    public UserList(){
        UsersList = new ArrayList<>();
        UsersList.add(new Funcionario("adm", 0, "senhadoadm"));
    }

    public void addAluno(String nome, int matricula, String senha){
        Aluno newStudent = new Aluno(nome, matricula, senha);
        UsersList.add(newStudent);
    }

    public Usuario searchUser(int matricula){
        try{
            for (Usuario current : this.UsersList) {
                if (current.getMatricula()==(matricula)) {
                    return current;
                }
            }
        }catch (Exception e){
            System.out.println("usuario não encontrado");
        }
        return null;
    }

    public void removeUser(int matricula) {
        try {
            for (Usuario current : this.UsersList) {
                if (current.getMatricula()==(matricula)) {
                    this.UsersList.remove(current);
                }
            }
        } catch (Exception e) {
            System.out.println("usuario não encontrado");
        }
    }

    public ArrayList<Usuario> getUsersList() {
        return UsersList;
    }
}
