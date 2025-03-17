package pessoa;

import sistema.Main;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private int cep;
    private long cpf;
    private int senha;

    Main principal = new Main();

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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
        public void cadastrarCliente(Scanner scanner) {
            // Nome
            while (true) {
                System.out.print("Digite seu nome: ");
                String nomeDigitado = scanner.nextLine().trim();

                if (!nomeDigitado.matches(".*\\d.*") && !nomeDigitado.isEmpty()) {
                    this.nome = nomeDigitado;
                    break;
                }
                System.out.println("Erro! Vai bobão (biel)! Digite um nome válido.");
            }

            // Idade
            while (true) {
                System.out.print("Digite sua idade: ");
                if (scanner.hasNextInt()) {
                    int idadeDigitada = scanner.nextInt();
                    if (idadeDigitada >= 0) { // Garante que a idade seja positiva
                        this.idade = idadeDigitada;
                        scanner.nextLine(); // Limpa o buffer
                        break;
                    }
                } else {
                    scanner.next(); // Limpa entrada inválida
                }
                System.out.println("Erro! Digite uma idade válida (número positivo).");
            }

            // CEP
            while (true) {
                System.out.print("Digite seu CEP: ");
                if (scanner.hasNextInt()) {
                    int cepDigitado = scanner.nextInt();
                    if (cepDigitado > 0) { // Evita valores negativos
                        this.cep = cepDigitado;
                        scanner.nextLine(); // Limpa o buffer
                        break;
                    }
                } else {
                    scanner.next(); // Limpa entrada inválida
                }
                System.out.println("Erro! Digite um CEP válido.");
            }

            // CPF
            while (true) {
                System.out.print("Digite seu CPF (somente números, sem pontos ou traços): ");
                if (scanner.hasNextLong()) { // CPF pode ter 11 dígitos, então usamos `long`
                    long cpfDigitado = scanner.nextLong();
                    if (cpfDigitado > 0) {
                        this.cpf = cpfDigitado;
                        scanner.nextLine(); // Limpa o buffer
                        break;
                    }
                } else {
                    scanner.next(); // Limpa entrada inválida
                }
                System.out.println("Erro! Digite um CPF válido.");
            }

            // Senha
            while (true) {
                System.out.print("Digite sua senha (mínimo 4 dígitos): ");
                if (scanner.hasNextInt()) {
                    int senhaDigitada = scanner.nextInt();
                    int numDigits = String.valueOf(Math.abs(senhaDigitada)).length();

                    if (numDigits >= 4) {
                        this.senha = senhaDigitada;
                        scanner.nextLine(); // Limpa o buffer
                        break;
                    }
                } else {
                    scanner.next(); // Limpa entrada inválida
                }
                System.out.println("Erro! A senha precisa ter pelo menos 4 dígitos.");
            }

            System.out.println("Cadastro realizado com sucesso!");
        }
    }
