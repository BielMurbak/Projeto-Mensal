package pagamento;

import cliente.ClientedeAtacado;

import java.util.Random;

public class Extrato {

    private int numeroPedido;
    private double valorTotal;
    private Pagamento pagamento;  // Composição: Pedido tem um pagamento
    Random random = new Random();
    ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();

    public Extrato(Pagamento pagamento, double valorTotal) {
        this.pagamento = pagamento;
        this.valorTotal = valorTotal;
        this.numeroPedido = random.nextInt(101);  // Inicializando o número do pedido aleatoriamente
    }

    public void exibirExtrato(int opcao,double valor) {
        System.out.println("\n");
        System.out.println("Número do Pedido: " + numeroPedido);

        if(novoClienteAtacado.getCnpj() == 0){
            if(opcao==2){
                valor = valor * 0.3;
                System.out.println("ValorTotal: " + valorTotal);
            }else if(opcao==3){
                double aux = 0;
                aux = valor;
                aux = valor * 0.10;
                valor-=aux;
                System.out.println("ValorTotal: " + valorTotal);
            }else if(opcao==4){
                double aux = 0;
                aux = valor;
                aux = valor * 0.125;
                valor-=aux;
                System.out.println("ValorTotal: " + valorTotal);
            }
        }

        pagamento.realizarPagamento(valorTotal);


    }


    // Getters e Setters
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}