package pedidos;

public class Pedido {
    private StatusPedido status; // Enum agora

    public Pedido() {

        this.status = StatusPedido.PROCESSANDO; // Pedido inicia como processando
    }

    public void atualizarStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
    }

    public void exibirPedido() {
        System.out.println("Status: " + status.getDescricao());
    }
}