package pessoa;

import java.util.ArrayList;
import java.util.Scanner;

//Class Cliente
// Atributos exclusivos para ClienteAtacado

 public class ClienteAtacado extends Pessoa {
    private double descontoEspecial;
    private long cnpj;

    // Lista para armazenar os clientes de atacado cadastrados
    public static ArrayList<ClienteAtacado> catalogoClienteAtacado = new ArrayList<>();

    // Getters e Setters
    public double getDescontoEspecial() {
        return descontoEspecial;
    }

    public void setDescontoEspecial(double descontoEspecial) {
        this.descontoEspecial = descontoEspecial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    //metodo pra cadasdrarClienteAtacado
    public void cadastrarCliente(Scanner scanner){
        super.cadastrarCliente(scanner); //chama funcao na class Pessoa

        // Verifica se a idade do cliente é menor que 18
        if (getIdade() < 18) {
            System.out.println("Erro! Idade não permitida. Retornando ao menu principal.");
            return;
        }

        // Solicita o CNPJ do cliente
        while(true) {
            System.out.print("Digite o seu CNPJ: ");
            if (scanner.hasNextLong()) {
                long cnpj = scanner.nextLong();
                if (cnpj > 0) {
                    this.cnpj=cnpj;
                    break;
                }

            } else {
                scanner.next(); //limpa a entrada invalida
            }
            System.out.println("Erro! Digite uma entrada valida");
        }

        // Solicita o desconto especial em porcentagem

        while(true) {
            System.out.print("Digite o desconto especial em porcentagem: ");
            if (scanner.hasNextDouble()) {
                double porcentagemAtacado = scanner.nextLong();
                if (porcentagemAtacado > 0) {
                    this.descontoEspecial=porcentagemAtacado;
                    break;
                }

            } else {
                scanner.next(); //limpa a entrada invalida
            }
            System.out.println("Erro! Digite uma entrada valida");
        }

        // Cria um novo cliente de atacado e define seus atributos
        ClienteAtacado novoClienteAtacado = new ClienteAtacado();
        novoClienteAtacado.setNome(getNome());
        novoClienteAtacado.setIdade(getIdade());
        novoClienteAtacado.setCep(getCep());
        novoClienteAtacado.setSenha(getSenha());
        novoClienteAtacado.setCnpj(cnpj);
        novoClienteAtacado.setDescontoEspecial(descontoEspecial);

        // Adiciona o novo cliente de atacado à lista de clientes de atacado
        catalogoClienteAtacado.add(novoClienteAtacado);

        System.out.println("✅ Cliente de Atacado criado com sucesso!");

    }
}
