package frete;

public class FreteExpresso implements Frete, SeguroFrete {
    @Override
    public double calcularFrete(double total) {
        if(total < 500.0) {
            return 35.0;
        }
        return 20;
    }

    @Override
    public double calcularSeguro(double valor) {
        return valor * 0.02; // Seguro 2% do valor
    }
}
