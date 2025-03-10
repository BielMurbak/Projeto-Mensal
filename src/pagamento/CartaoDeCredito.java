package pagamento;

import cliente.ClientedeAtacado;
import sistema.SistemaUsuario;

import java.util.Random;
import java.util.Scanner;

// Classe que representa o pagamento via cartão de crédito, estendendo a classe Pagamento.
public class CartaoDeCredito extends Pagamento {

    // Instância do scanner para leitura de entradas do usuário.
    Scanner scanner = new Scanner(System.in);

    // Instância do random para gerar números aleatórios (ex.: número do pedido).
    Random random = new Random();

    @Override
    public void realizarPagamento(double valor) {

        // Cria um novo objeto ClientedeAtacado para representar o cliente de atacado.
        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();
        double aux = 0;

        // Solicita ao usuário o número de parcelas do pagamento.
        System.out.println("Digite o numero de parcelas:");
        int parcelas = scanner.nextInt();

        // Lógica para pagamento em até 3 parcelas
        if (parcelas <= 3) {
            // Verifica se o cliente é de atacado (CNPJ válido)
            if (novoClienteAtacado.getCnpj() != 0) {
                // Aplica o desconto especial do cliente de atacado
                valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

                // Gera um número de pedido aleatório
                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);

                // Exibe o valor total após o desconto do cliente de atacado
                System.out.printf("Total no pix com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);
            }

            // Exibe o número do pedido e o total dividido pelas parcelas
            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);
            System.out.printf("Total com %d parcelas:%.2f", parcelas, valor);

        }

        // Lógica para pagamento em 4 parcelas
        if (parcelas == 4) {
            if (novoClienteAtacado.getCnpj() != 0) {
                // Aplica uma taxa adicional de 10% para o pagamento em 4 parcelas
                valor = valor * 0.10;
                valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

                // Gera um número de pedido aleatório
                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);

                // Exibe o valor total após o desconto do cliente de atacado
                System.out.printf("Total no pix com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);
            }

            // Aplica a taxa adicional de 10% no valor
            aux = valor;
            valor += aux * 0.10;

            // Exibe o número do pedido e o total dividido pelas parcelas
            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);
            System.out.printf("Total com %d parcelas:%.2f", parcelas, valor);
        }

        // Lógica para pagamento em 5 parcelas
        if (parcelas == 5) {
            if (novoClienteAtacado.getCnpj() != 0) {
                // Aplica uma taxa adicional de 15% para o pagamento em 5 parcelas
                valor = valor * 0.15;
                valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

                // Gera um número de pedido aleatório
                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);

                // Exibe o valor total após o desconto do cliente de atacado
                System.out.printf("Total no pix com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);
            }

            // Aplica a taxa adicional de 15% no valor
            aux = valor;
            valor += aux * 0.15;

            // Exibe o número do pedido e o total dividido pelas parcelas
            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);
            System.out.printf("Total com %d parcelas:%.2f", parcelas, valor);
        }

        // Lógica para pagamento em 6 parcelas
        if (parcelas == 6) {
            if (novoClienteAtacado.getCnpj() != 0) {
                // Aplica uma taxa adicional de 20% para o pagamento em 6 parcelas
                valor = valor * 0.20;
                valor += valor;
                valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

                // Gera um número de pedido aleatório
                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);

                // Exibe o valor total após o desconto do cliente de atacado
                System.out.printf("Total no pix com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);
            }

            // Aplica a taxa adicional de 20% no valor
            aux = valor;
            valor += aux * 0.20;

            // Exibe o número do pedido e o total dividido pelas parcelas
            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);
            System.out.printf("Total com %d parcelas:%.2f", parcelas, valor);
        }

        // Lógica para pagamento em mais de 6 parcelas
        if (parcelas > 6) {
            if (novoClienteAtacado.getCnpj() != 0) {
                // Aplica uma taxa adicional de 50% para o pagamento em mais de 6 parcelas
                valor = valor * 0.5;
                valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

                // Gera um número de pedido aleatório
                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);

                // Exibe o valor total após o desconto do cliente de atacado
                System.out.printf("Total no pix com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);
            }

            // Aplica a taxa adicional de 50% no valor
            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);

            aux = valor;
            valor += aux * 0.5;

            // Exibe o número do pedido e o total dividido pelas parcelas
            System.out.printf("Total com %d parcelas:%.2f", parcelas, valor);
        }

    }

}
