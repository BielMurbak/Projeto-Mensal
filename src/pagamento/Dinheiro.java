package pagamento;

import cliente.ClientedeAtacado;

public class Dinheiro extends Pagamento {

    @Override
    public void realizarPagamento(double valor) {

        // Cria um novo objeto ClientedeAtacado para representar o cliente de atacado.
        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();

        // Verifica se o cliente é de atacado, identificado pelo CNPJ.
        if (novoClienteAtacado.getCnpj() != 0) {

            // Aplica um desconto de 12.5% ao valor.
            double aux = 0;
            aux = valor;
            aux = valor * 0.125;
            valor -= aux;  // Subtrai o valor do desconto de 12.5% do valor original.

            // Aplica o desconto especial do cliente de atacado.
            valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

            // Exibe o valor total após o desconto de 12.5% e o desconto especial do cliente de atacado.
            System.out.printf("Total no pix com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);
        }
    }
}
