package pagamento;

import cliente.Cliente;
import cliente.ClientedeAtacado;

import java.util.Random;

import static cliente.Cliente.catalogoCliente;

// Classe responsável por gerar o extrato de um pedido de pagamento.
public class Extrato {

    private int numeroPedido;  // Número único do pedido
    private double valorTotal;  // Valor total do pedido
    private Pagamento pagamento;  // Composição: Cada extrato tem um tipo de pagamento associado

    Random random = new Random();  // Instância do Random para gerar números aleatórios
    ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();  // Cliente de atacado para obter o CNPJ
    Cliente cliente = new Cliente();
    double aux = 0;
    // Construtor que inicializa um extrato com o pagamento e o valor total
    public Extrato(Pagamento pagamento, double valorTotal) {
        this.pagamento = pagamento;
        this.valorTotal = valorTotal;
        this.numeroPedido = random.nextInt(101);  // Inicializa o número do pedido aleatoriamente entre 0 e 100
    }

    // Método responsável por exibir o extrato do pedido
    public double exibirExtrato(int opcao, double valor) {
        System.out.println("\n");
        System.out.println("Número do Pedido: " + numeroPedido);// Exibe o número do pedido gerado
        for (Cliente cliente2 : catalogoCliente) {
            System.out.println("Nome: " + cliente2.getNome());
            break;
        }

        // Verifica se o cliente de atacado tem CNPJ 0, indicando que não é um cliente de atacado
        if (novoClienteAtacado.getCnpj() == 0) {
            System.out.println("Tipo de cliente:Varejo");
            // Caso o cliente opte por um pagamento com desconto de 30% (opção 2)
            if (opcao == 2) {
                aux = valor;
                aux = valor * 0.05;  // Aplica um desconto de 10% ao valor
                valor -= aux;  // Subtrai o valor do desconto de 10%
                System.out.println("ValorTotal: " + valor);  // Exibe o valor total

                // Caso o cliente opte por um pagamento com 10% de desconto (opção 3)
            } else if (opcao == 3) {

                aux = valor;
                aux = valor * 0.10;  // Aplica um desconto de 10% ao valor
                valor -= aux;  // Subtrai o valor do desconto de 10%
                System.out.println("ValorTotal: " + valor);  // Exibe o valor total

                // Caso o cliente opte por um pagamento com 12.5% de desconto (opção 4)
            } else if (opcao == 4) {

                aux = valor;
                aux = valor * 0.10;  // Aplica um desconto de 12.5% ao valor
                valor -= aux;  // Subtrai o valor do desconto de 12.5%
                System.out.println("ValorTotal: " + valor); // Exibe o valor total
                return valorTotal;

            }
        }else{
            System.out.println("Tipo de cliente:Atacado");
        }

        // Chama o método realizarPagamento do objeto pagamento associado ao extrato
        pagamento.realizarPagamento(valorTotal);
        return valorTotal;
    }

    // Getters e Setters

    public int getNumeroPedido() {
        return numeroPedido;  // Retorna o número do pedido
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;  // Define o número do pedido
    }

    public double getValorTotal() {
        return valorTotal;  // Retorna o valor total do pedido
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;  // Define o valor total do pedido
    }

    public Pagamento getPagamento() {
        return pagamento;  // Retorna o objeto de pagamento associado
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;  // Define o objeto de pagamento associado
    }
}
