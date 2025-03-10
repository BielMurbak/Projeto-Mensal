package cliente;

import java.util.ArrayList;
import java.util.Scanner;

// Classe ClientedeAtacado herda de Cliente (Cliente de Atacado)
public class ClientedeAtacado extends Cliente {
    // Atributos exclusivos para ClientedeAtacado
    private double descontoEspecial; // Desconto especial para clientes de atacado
    private long cnpj; // CNPJ do cliente de atacado

    // Lista para armazenar os clientes de atacado cadastrados
    public static ArrayList<ClientedeAtacado> catalogoClienteAtacado = new ArrayList<>();

    // Getters e Setters
    public double getDescontoEspecial() {
        return descontoEspecial; // Retorna o valor do desconto especial
    }

    public void setDescontoEspecial(double descontoEspecial) {
        this.descontoEspecial = descontoEspecial; // Define o desconto especial
    }

    public long getCnpj() {
        return cnpj; // Retorna o CNPJ do cliente de atacado
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj; // Define o CNPJ do cliente de atacado
    }

    // Método para cadastrar um cliente de atacado
    public void cadastrarCliente(Scanner scanner){
        // Chama o método cadastrarCliente da classe pai (Cliente)
        super.cadastrarCliente(scanner);

        // Limpa o buffer do scanner
        scanner.nextLine();

        // Verifica se a idade do cliente é menor que 18
        if (getIdade() < 18) {
            System.out.println("Erro! Idade não permitida. Retornando ao menu principal.");
            return; // Se a idade for menor que 18, retorna ao menu sem cadastrar
        }

        // Solicita o CNPJ do cliente
        System.out.print("Digite o seu CNPJ: ");
        this.cnpj = scanner.nextLong();

        // Solicita o desconto especial em porcentagem
        System.out.print("Digite o desconto especial em porcentagem: ");
        this.descontoEspecial = scanner.nextDouble();
        System.out.println("Cadastro de Cliente Atacado concluído.");

        // Cria um novo cliente de atacado e define seus atributos
        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();
        novoClienteAtacado.setNome(getNome());
        novoClienteAtacado.setIdade(getIdade());
        novoClienteAtacado.setCep(getCep());
        novoClienteAtacado.setSenha(getSenha());
        novoClienteAtacado.setCnpj(cnpj);
        novoClienteAtacado.setDescontoEspecial(descontoEspecial);

        // Adiciona o novo cliente de atacado à lista de clientes de atacado
        catalogoClienteAtacado.add(novoClienteAtacado);
    }
}
