package pedidos;

public enum StatusPedido {
    PROCESSANDO("Processando"),  // Status quando o pedido está sendo processado
    ENVIADO("Enviado"),          // Status quando o pedido foi enviado
    SEPARADO("Separado"),        // Status quando os itens do pedido estão separados
    ENTREGUE("Entregue"),        // Status quando o pedido foi entregue
    CANCELADO("Cancelado");      // Status quando o pedido foi cancelado

    private final String descricao;  // Atributo para armazenar a descrição do status

    // Construtor do enum, que recebe uma descrição para cada status
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    // Método para obter a descrição do status
    public String getDescricao() {
        return descricao;
    }
}
