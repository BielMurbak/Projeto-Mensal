package pagamento;

// Classe abstrata que define um contrato para pagamentos
public abstract class Pagamento {

    // Método abstrato que deve ser implementado pelas subclasses para realizar o pagamento
    public abstract double realizarPagamento(double valor);

}
