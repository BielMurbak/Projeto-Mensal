package sistema;


import java.util.ArrayList;
import java.util.Scanner;

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


    public void adicionarAdm(Scanner scanner){

        System.out.print("Digite seu nome: ");
        String nomeAdm = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idadeAdm = scanner.nextInt();

        System.out.print("Digite seu CEP: ");
        int cepAdm = scanner.nextInt();

        System.out.print("Digite sua senha (número): ");
        int senhaAdm = scanner.nextInt();

        System.out.println("Cadastro do Administrador realizado com sucesso");

        Administrador novoAdm = new Administrador();

        novoAdm.setNome(nomeAdm);
        novoAdm.setIdade(idadeAdm);
        novoAdm.setCep(cepAdm);
        novoAdm.setSenha(senhaAdm);
        listaAdm.add(novoAdm);

    }

}
