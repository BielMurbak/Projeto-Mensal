package frete;

public class FreteExpresso implements Frete, SeguroFrete {

    private double taxa;
    private int tempoDeEntrega;

    @Override
    public int getTempoDeEntrega() {
        return tempoDeEntrega;
    }

    public FreteExpresso(double taxa, int tempoDeEntrega) {
        this.tempoDeEntrega = tempoDeEntrega;
        this.taxa = taxa;
    }

    public FreteExpresso(int tempoDeEntrega) {
        this.tempoDeEntrega = tempoDeEntrega;
    }

    @Override
    public double calcularFrete(double total) {
        if(total < 500.0) {
            return 35.0;
        }
        return 20;
    }

    @Override
    public double calcularSeguro(double valor) {
        return valor * taxa; // Seguro 2% do valor
    }
}
