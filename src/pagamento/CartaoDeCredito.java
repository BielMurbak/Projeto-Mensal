package pagamento;

import cliente.ClientedeAtacado;
import sistema.SistemaUsuario;

import java.util.Scanner;

public class CartaoDeCredito extends Pagamento {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void realizarPagamento(double valor) {

        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();

        System.out.println("Digite o numero de parcelas:");
        int parcelas = scanner.nextInt();

        if(parcelas<3){
            if (novoClienteAtacado.getCnpj() != 0) {

                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);

        }
        if(parcelas==4){

            if (novoClienteAtacado.getCnpj() != 0) {
                valor = valor * 0.10;
                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }

            valor = valor * 0.10;

            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);
        }
        if(parcelas==5){
            if (novoClienteAtacado.getCnpj() != 0) {
                valor = valor * 0.15;
                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }

            valor = valor * 0.15;
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);
        }
        if(parcelas==6){

            if (novoClienteAtacado.getCnpj() != 0) {
                valor = valor * 0.20;
                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }

            valor = valor * 0.20;
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);
        }
        if(parcelas>6){
            if (novoClienteAtacado.getCnpj() != 0) {
                valor = valor * 0.5;
                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }

            valor = valor * 0.5;
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);
        }

    }

}
