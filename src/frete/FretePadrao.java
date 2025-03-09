package frete;

public class FretePadrao implements Frete {
    @Override
    public double calcularFrete(double total) {
        if (total < 500.0) {
            return 20.0;
        }
        return 10.0;
    }
}