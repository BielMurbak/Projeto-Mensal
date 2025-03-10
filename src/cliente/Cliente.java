package cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente{
    // Atributos da classe Cliente
    private String nome; // Nome do cliente
    private int idade; // Idade do cliente
    private int cep; // CEP do cliente
    private int senha; // Senha de acesso do cliente
    private int tipo = 1; // Tipo de cliente (1 por padrão, pode ser alterado)

    // Lista estática para armazenar todos os clientes cadastrados
    public static ArrayList<Cliente> catalogoCliente = new ArrayList<>();

    // Getters e setters para os atributos da classe Cliente
    public String getNome() {
        return nome; // Retorna o nome do cliente
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome do cliente
    }

    public int getIdade() {
        return idade; // Retorna a idade do cliente
    }

    public void setIdade(int idade) {
        this.idade = idade; // Define a idade do cliente
    }

    public int getCep() {
        return cep; // Retorna o CEP do cliente
    }

    public void setCep(int cep) {
        this.cep = cep; // Define o CEP do cliente
    }

    public int getSenha() {
        return senha; // Retorna a senha do cliente
    }

    public void setSenha(int senha) {
        this.senha = senha; // Define a senha do cliente
    }

    public int getTipo() {
        return tipo; // Retorna o tipo de cliente
    }

    // Método para cadastrar um cliente
    public void cadastrarCliente(Scanner scanner){
        // Solicita e armazena os dados do cliente
        System.out.print("Digite seu nome: ");
        this.nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        this.idade = scanner.nextInt();

        System.out.print("Digite seu CEP: ");
        this.cep = scanner.nextInt();

        System.out.print("Digite sua senha (número): ");
        this.senha = scanner.nextInt();

        // Cria um novo objeto Cliente e o adiciona à lista de clientes
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nome);
        novoCliente.setIdade(idade);
        novoCliente.setCep(cep);
        novoCliente.setSenha(senha);

        // Adiciona o novo cliente ao catálogo de clientes
        catalogoCliente.add(novoCliente);
    } // Fecha o método cadastrarCliente

    // Método estático para remover um cliente baseado no nome e senha
    static boolean removerCliente(String nomeClienteRemover ,int senhaClienteRemover ){
        for (Cliente cliente : catalogoCliente) {
            // Verifica se o nome do cliente corresponde e a senha está correta
            if (cliente.nome.equalsIgnoreCase(nomeClienteRemover)) {
                if(cliente.senha == senhaClienteRemover) {
                    catalogoCliente.remove(cliente); // Remove o cliente da lista
                    System.out.println("✅ Cliente removido com sucesso!");
                    return true;
                }
            }
        }
        System.out.println("Cliente não foi encontrado!"); // Caso o cliente não seja encontrado
        return false;
    }

    // Método estático para alterar a senha de um cliente
    public static boolean alterarSenha(String nomeCliente, int senhaAtual, int novaSenha) {
        for (Cliente cliente : catalogoCliente) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                if (cliente.getSenha() == senhaAtual) {
                    cliente.setSenha(novaSenha); // Altera a senha do cliente
                    System.out.println("Senha alterada com sucesso!");
                    return true;
                } else {
                    System.out.println("Senha atual incorreta."); // Se a senha atual estiver errada
                    return false;
                }
            }
        }
        System.out.println("Cliente não encontrado."); // Se o cliente não for encontrado
        return false;
    }

    // Método estático para alterar o nome de um cliente
    public static boolean alterarNome(String nomeCliente, int senhaAtual, String novoNome) {
        for (Cliente cliente : catalogoCliente) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                if (cliente.getSenha() == senhaAtual) {
                    cliente.setNome(novoNome); // Altera o nome do cliente
                    System.out.println("Nome alterado com sucesso!");
                    return true;
                } else {
                    System.out.println("Senha atual incorreta."); // Se a senha atual estiver errada
                    return false;
                }
            }
        }
        System.out.println("Cliente não encontrado."); // Se o cliente não for encontrado
        return false;
    }
}
