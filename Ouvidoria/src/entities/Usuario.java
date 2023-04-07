package entities;


public class Usuario {
    private String nome;
    private String senha;
    private int matricula;



    public Usuario(String nome, int matricula, String senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getMatricula() {
        return matricula;
    }


    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }
}
