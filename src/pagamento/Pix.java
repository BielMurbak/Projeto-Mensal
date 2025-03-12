package pagamento;
import pessoa.ClienteAtacado;

// Classe que representa o pagamento via Pix, herda de Pagamento
public class Pix extends Pagamento {

    // Implementação do método abstrato realizarPagamento para o pagamento via Pix
    public double realizarPagamento(double valor) {

        // Criando uma instância do clienteVarejo
        ClienteAtacado novoClienteAtacado = new ClienteAtacado();

        // Verifica se o clienteVarejo tem um CNPJ válido (não é zero)
        if (novoClienteAtacado.getCnpj() != 0) {

            // Calcula o desconto de 10% para o pagamento via Pix
            double aux = 0;
            aux = valor;
            aux = valor * 0.125;  // Desconto de 10%
            valor -= aux;  // Subtrai o desconto de 10%

            // Aplica o desconto especial do clienteVarejo, se houver
            valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

            // Exibe o valor final a ser pago após o desconto do clienteVarejo
            System.out.printf("Total no pix com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);
        }
        return valor;
    }
}
