package pagamento;

import cliente.ClientedeAtacado;

public class CartaoDebito extends Pagamento {

    @Override
    public void realizarPagamento(double valor) {

        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();

        if (novoClienteAtacado.getCnpj() != 0) {

            valor = valor * 0.3;
            valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

            System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
        }

    }
}