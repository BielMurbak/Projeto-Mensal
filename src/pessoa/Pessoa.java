package pessoa;

import sistema.Main;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private int cep;
    private int cpf;
    private int senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void cadastrarCliente(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        String nomeDigitado = scanner.nextLine();

        // Verifica se o nome contém números
        if (nomeDigitado.matches(".*\\d.*")) {
            System.out.println("Erro! Vai bobão!.");
            Main principal = new Main();
            principal.main(null);
        }else{
            this.nome = nome;
        }

        this.nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        this.idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite seu CEP: ");
        this.cep = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        this.cpf = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite sua senha: ");
        this.senha = scanner.nextInt();
        scanner.nextLine();
    }

}
