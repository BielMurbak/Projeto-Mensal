package pagamento;

import pessoa.ClienteAtacado;
import pessoa.ClienteVarejo;

import java.util.Random;
import java.util.Scanner;

import static pessoa.ClienteVarejo.catalogoClienteVarejo;

public class CartaoDeCredito extends Pagamento {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    @Override
    public double realizarPagamento(double valor) {
        ClienteAtacado novoClienteAtacado = new ClienteAtacado();
        boolean isAtacado = novoClienteAtacado.getCnpj() != 0;
        double valorFinal = valor;

        System.out.println("Digite o número de parcelas:");
        int parcelas = scanner.nextInt();

        // Aplica taxas conforme o número de parcelas
        if (parcelas > 6) {
            valorFinal *= 1.30; // Aumento de 30%
        } else if (parcelas == 6) {
            valorFinal *= 1.20; // Aumento de 20%
        } else if (parcelas == 5) {
            valorFinal *= 1.15; // Aumento de 15%
        } else if (parcelas == 4) {
            valorFinal *= 1.10; // Aumento de 10%
        }

        // Aplica desconto se for clienteVarejo de atacado
        if (isAtacado) {
            valorFinal -= valorFinal * (novoClienteAtacado.getDescontoEspecial() / 100.0);
        }

        // Gera um número de pedido aleatório
        int numeroPedido = random.nextInt(101);
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("Tipo de cliente: " + (isAtacado ? "Atacado" : "Varejo"));

        // Exibe o nome do clienteVarejo
        for (ClienteVarejo clienteVarejo2 : catalogoClienteVarejo) {
            System.out.println("Nome: " + clienteVarejo2.getNome());
            break;
        }

        // Exibe o total e o valor por mês
        System.out.printf("Total: %.2f\n", valorFinal);
        System.out.println("Número de parcelas: " + parcelas);
        System.out.printf("Valor por mês: %.2f\n", valorFinal / parcelas);

        return valorFinal; // Retorna o valor final calculado
    }
}
