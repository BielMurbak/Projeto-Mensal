package frete;

// Interface Frete define métodos que devem ser implementados pelas classes que calculam o frete.
public interface Frete {

    // Método para calcular o valor do frete baseado no valor total da compra.
    // Recebe o valor total como parâmetro e retorna o valor do frete.
    double calcularFrete(double total);

    // Método para obter o tempo de entrega do frete.
    // Retorna o tempo de entrega em número inteiro (por exemplo, em dias).
    int getTempoDeEntrega();
}
