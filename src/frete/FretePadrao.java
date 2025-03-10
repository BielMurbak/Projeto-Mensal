package frete;

// A classe FretePadrao implementa a interface Frete
public class FretePadrao implements Frete {

    // Declaração da variável tempoDeEntrega
    private int tempoDeEntrega;

    // Construtor da classe FretePadrao
    // O valor da variável tempoDeEntrega é setado como 8 (dentro do construtor)
    public FretePadrao(int tempoDeEntrega){
        this.tempoDeEntrega = 8; // O tempo de entrega é fixo como 8, independentemente do valor passado
    }

    // Método que calcula o custo do frete baseado no valor total da compra

    @Override
    public double calcularFrete(double total) {
        // Se o total for menor que 500, o frete será 20
        if (total < 500.0) {
            return 20.0;
        }
        // Caso contrário, o frete será 10
        return 10.0;
    }

    // Método que retorna o tempo de entrega
    @Override
    public int getTempoDeEntrega() {
        return tempoDeEntrega;
    }

}
