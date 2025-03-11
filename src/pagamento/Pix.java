package pagamento;
import cliente.ClientedeAtacado;
import sistema.SistemaUsuario;

// Classe que representa o pagamento via Pix, herda de Pagamento
public class Pix extends Pagamento {

    // Implementação do método abstrato realizarPagamento para o pagamento via Pix
    public double realizarPagamento(double valor) {

        // Criando uma instância do cliente
        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();

        // Verifica se o cliente tem um CNPJ válido (não é zero)
        if (novoClienteAtacado.getCnpj() != 0) {

            // Calcula o desconto de 10% para o pagamento via Pix
            double aux = 0;
            aux = valor;
            aux = valor * 0.125;  // Desconto de 10%
            valor -= aux;  // Subtrai o desconto de 10%

            // Aplica o desconto especial do cliente, se houver
            valor -= valor * (novoClienteAtacado.getDescontoEspecial() / 100.0);

            // Exibe o valor final a ser pago após o desconto do cliente
            System.out.printf("Total no pix com desconto de %d%%: %.2f", novoClienteAtacado.getDescontoEspecial(), valor);
        }
        return valor;
    }
}
