package frete;

// Classe que implementa as interfaces Frete e SeguroFrete.
// Calcula o valor do frete expresso e o valor do seguro sobre o valor total.
public class FreteExpresso implements Frete, SeguroFrete {

    private double taxa;  // A taxa do seguro (percentual).
    private int tempoDeEntrega;  // Tempo de entrega do frete expresso.

    // Método que retorna o tempo de entrega.
    @Override
    public int getTempoDeEntrega() {
        return tempoDeEntrega;
    }

    // Construtor que recebe a taxa e o tempo de entrega.
    public FreteExpresso(double taxa, int tempoDeEntrega) {
        this.tempoDeEntrega = tempoDeEntrega;
        this.taxa = taxa;
    }

    // Construtor que apenas recebe o tempo de entrega, sem a taxa do seguro.
    public FreteExpresso(int tempoDeEntrega) {
        this.tempoDeEntrega = tempoDeEntrega;
    }

    // Método que calcula o valor do frete com base no total da compra.
    @Override
    public double calcularFrete(double total) {
        if (total < 500.0) {  // Se o valor da compra for menor que 500, frete é R$ 35.
            return 35.0;
        }
        return 20.0;  // Caso contrário, o frete é R$ 20.
    }

    // Método que calcula o valor do seguro com base no valor da compra.
    @Override
    public double calcularSeguro(double valor) {
        return valor * taxa;  // O seguro é uma porcentagem do valor total da compra.
    }
}
