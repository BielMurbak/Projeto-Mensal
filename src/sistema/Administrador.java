package sistema;


import java.util.ArrayList;

public class Administrador {
    protected String nome;
    protected int idade;
    protected int cep;
    protected int senha;
    public ArrayList<Administrador> listaAdm = new ArrayList<>();

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
