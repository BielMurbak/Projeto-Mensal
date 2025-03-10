package pagamento;
import cliente.ClientedeAtacado;
import sistema.SistemaUsuario;

public class Pix extends Pagamento{

    public void realizarPagamento(double valor) {

        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();


        if (novoClienteAtacado.getCnpj() != 0) {

            double aux = 0;
            aux = valor;
            aux = valor * 0.10;
            valor-=aux;

            valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

            System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
        }



    }
}