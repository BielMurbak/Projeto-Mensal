package pedidos;

public class Pedido {
    private StatusPedido status; // Atributo que armazena o status do pedido, agora utilizando um Enum

    // Construtor padrão
    public Pedido() {
        this.status = StatusPedido.PROCESSANDO; // Inicializa o pedido com o status "PROCESSANDO"
    }

    // Método para atualizar o status do pedido
    public void atualizarStatus(StatusPedido novoStatus) {
        StatusPedido statusPedido = StatusPedido.PROCESSANDO; // Status do pedido (inicialmente PROCESSANDO)
        this.status = novoStatus; // Atualiza o status do pedido para o novo valor
    }

    // Método para exibir o status atual do pedido
    public void exibirPedido() {
        System.out.println("Status: " + status.getDescricao()); // Exibe a descrição do status do pedido
    }
}
