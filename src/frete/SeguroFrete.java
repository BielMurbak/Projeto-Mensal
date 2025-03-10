package frete;

// Interface que define um método para calcular o valor do seguro do frete.
public interface SeguroFrete {

    // Método que calcula o valor do seguro com base no valor da compra.
    // O método deverá ser implementado em qualquer classe que o utilize.
    double calcularSeguro(double valor);
}
