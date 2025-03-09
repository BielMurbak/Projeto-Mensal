package pedidos;

public enum StatusPedido {
    PROCESSANDO("Processando"),
    ENVIADO("Enviado"),
    SEPARADO("Separado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}