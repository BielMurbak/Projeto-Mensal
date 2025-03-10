package sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {
    protected String nome;        // Nome do administrador
    protected int idade;          // Idade do administrador
    protected int cep;            // CEP do administrador
    protected int senha;          // Senha do administrador
    public ArrayList<Administrador> listaAdm = new ArrayList<>();  // Lista de administradores cadastrados

    // Métodos Getters e Setters para cada atributo
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

    // Método para adicionar um novo administrador
    public void adicionarAdm(Scanner scanner) {
        // Solicita ao usuário que insira os dados do administrador
        System.out.print("Digite seu nome: ");
        String nomeAdm = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idadeAdm = scanner.nextInt();

        System.out.print("Digite seu CEP: ");
        int cepAdm = scanner.nextInt();

        System.out.print("Digite sua senha (número): ");
        int senhaAdm = scanner.nextInt();

        System.out.println("Cadastro do Administrador realizado com sucesso");

        // Cria um novo objeto de Administrador e preenche os dados fornecidos
        Administrador novoAdm = new Administrador();
        novoAdm.setNome(nomeAdm);
        novoAdm.setIdade(idadeAdm);
        novoAdm.setCep(cepAdm);
        novoAdm.setSenha(senhaAdm);

        // Adiciona o novo administrador à lista de administradores
        listaAdm.add(novoAdm);
    }
}
