package pagamento;
import sistema.SistemaUsuario;

public class Pix extends Pagamento{

    public void realizarPagamento(double valor) {

        System.out.printf("Total no pix:%.2f",valor);

        SistemaUsuario sistema = new SistemaUsuario();
        sistema.sistemaUsuario();
    }
}
