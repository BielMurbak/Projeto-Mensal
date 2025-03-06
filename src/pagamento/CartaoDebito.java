package pagamento;

import sistema.SistemaUsuario;

public class CartaoDebito extends Pagamento {

    @Override
    public void realizarPagamento(double valor) {

        valor = valor * 0.3;

        SistemaUsuario sistema = new SistemaUsuario();
        sistema.sistemaUsuario();
    }
}
