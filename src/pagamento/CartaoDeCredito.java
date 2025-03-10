package pagamento;

import cliente.ClientedeAtacado;
import sistema.SistemaUsuario;

import java.util.Random;
import java.util.Scanner;

public class CartaoDeCredito extends Pagamento {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    @Override
    public void realizarPagamento(double valor) {

        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();
        double aux = 0;

        System.out.println("Digite o numero de parcelas:");
        int parcelas = scanner.nextInt();

        if(parcelas<=3){
            if (novoClienteAtacado.getCnpj() != 0) {

                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);
                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }
            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);


        }
        if(parcelas==4){

            if (novoClienteAtacado.getCnpj() != 0) {
                valor = valor * 0.10;
                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);
                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }


            aux = valor;
            valor += aux * 0.10;

            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);
        }
        if(parcelas==5){
            if (novoClienteAtacado.getCnpj() != 0) {
                valor = valor * 0.15;
                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);

                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);
                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }

            aux = valor;
            valor += aux * 0.15;
            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);
        }
        if(parcelas==6){

            if (novoClienteAtacado.getCnpj() != 0) {
                valor = valor * 0.20;
                valor+=valor;
                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);
                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);

                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }
            aux = valor;
            valor += aux * 0.20;

            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);
        }
        if(parcelas>6){
            if (novoClienteAtacado.getCnpj() != 0) {
                valor = valor * 0.5;
                valor -= valor * ( novoClienteAtacado.getDescontoEspecial() / 100.0);
                int numeroPedido = random.nextInt(101);
                System.out.println("Número do Pedido: " + numeroPedido);
                System.out.printf("Total no pix com desconto de %d%%: %.2f",      novoClienteAtacado.getDescontoEspecial(), valor);
            }
            int numeroPedido = random.nextInt(101);
            System.out.println("Número do Pedido: " + numeroPedido);

            aux = valor;
            valor += aux * 0.5;
            System.out.printf("Total com %d parcelas:%.2f",parcelas,valor);

        }

    }

}