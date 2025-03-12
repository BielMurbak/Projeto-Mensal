package pagamento;

import pessoa.ClienteVarejo;
import pessoa.ClienteAtacado;

// Classe que representa o pagamento via cartão de débito, estendendo a classe Pagamento.
public class CartaoDebito extends Pagamento {

    // Método que realiza o pagamento via cartão de débito, aplicando desconto se o clienteVarejo for de atacado.
    @Override
    public double realizarPagamento(double valor) {

        // Cria um novo objeto ClienteAtacado para representar o clienteVarejo.
        ClienteAtacado novoClienteAtacado = new ClienteAtacado();
        ClienteVarejo clienteVarejo = new ClienteVarejo();

        // Verifica se o CNPJ do clienteVarejo é diferente de 0 (o clienteVarejo é um clienteVarejo de atacado válido).
        if (novoClienteAtacado.getCnpj() != 0) {

            // Aplica uma taxa extra de 30% no valor do pagamento (valor * 0.3).
            valor = valor * 0.05;

            // Aplica o desconto especial no valor (valor - (valor * desconto / 100)).
            valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

            // Exibe o valor final do pagamento, já com o desconto aplicado.
            System.out.printf("Total no cartão de débito com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);


        }
        return valor;
    }
}

