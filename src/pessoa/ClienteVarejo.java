package pessoa;

import java.util.ArrayList;
import java.util.Scanner;

//Class ClienteVarejo
// Atributos da classe ClienteVarejo

public class ClienteVarejo extends Pessoa{
  private double descontoFinalDaCompra;

    // Lista estática para armazenar todos os clientes cadastrados
    public static ArrayList<ClienteVarejo> catalogoClienteVarejo = new ArrayList<>();

    // Getters e setters para os atributos da classe ClienteVarejo

    public double getDescontoFinalDaCompra() {
        return descontoFinalDaCompra;
    }

    public void setDescontoFinalDaCompra(double descontoFinalDaCompra) {
        this.descontoFinalDaCompra = descontoFinalDaCompra;
    }

    //Metodo pra CadastrarCliente
    public void cadastrarCliente(Scanner scanner) {

        super.cadastrarCliente(scanner); //chama funcao na class Pessoa

        // Solicita o desconto especial em porcentagem
        System.out.print("Digite o desconto final: ");
        this.descontoFinalDaCompra=scanner.nextDouble();

        System.out.println("✅ Cliente de varejo criado com sucesso!");

    }

    //Metodo estatico pra remover a senha do cliente
    static boolean removerCliente(String nomeClienteRemover ,int senhaClienteRemover ){
        for (ClienteVarejo clienteVarejo : catalogoClienteVarejo) {
            // Verifica se o nome do clienteVarejo corresponde e a senha está correta
            if (clienteVarejo.getNome().equalsIgnoreCase(nomeClienteRemover)) {
                if(clienteVarejo.getSenha() == senhaClienteRemover) {
                    catalogoClienteVarejo.remove(clienteVarejo); // Remove o clienteVarejo da lista
                    System.out.println("✅ ClienteVarejo removido com sucesso!");
                    return true;
                }
            }
        }
        System.out.println("ClienteVarejo não foi encontrado!"); // Caso o cliente não seja encontrado
        return false;
    }

    //metodo de alterar senha do cliente varejo
    public static boolean alterarSenha(String nomeCliente, int senhaAtual, int novaSenha) {
        for (ClienteVarejo clienteVarejo : catalogoClienteVarejo) {
            if (clienteVarejo.getNome().equalsIgnoreCase(nomeCliente)) {
                if (clienteVarejo.getSenha() == senhaAtual) {
                    clienteVarejo.setSenha(novaSenha); // Altera a senha do clienteVarejo
                    System.out.println("Senha alterada com sucesso!");
                    return true;
                } else {
                    System.out.println("Senha atual incorreta."); // Se a senha atual estiver errada
                    return false;
                }
            }
        }
        System.out.println("ClienteVarejo não encontrado."); // Se o cliente não for encontrado
        return false;
    }

    //metodo de alterarNome de Cliente
    public static boolean alterarNome(String nomeCliente, int senhaAtual, String novoNome) {
        for (ClienteVarejo clienteVarejo : catalogoClienteVarejo) {
            if (clienteVarejo.getNome().equalsIgnoreCase(nomeCliente)) {
                if (clienteVarejo.getSenha() == senhaAtual) {
                    clienteVarejo.setNome(novoNome); // Altera o nome do clienteVarejo
                    System.out.println("Nome alterado com sucesso!");
                    return true;
                } else {
                    System.out.println("Senha atual incorreta."); // Se a senha atual estiver errada
                    return false;
                }
            }
        }
        System.out.println("ClienteVarejo não encontrado."); // Se o cliente não for encontrado
        return false;
    }
}
