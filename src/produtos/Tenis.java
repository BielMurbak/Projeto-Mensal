package produtos;

import java.util.ArrayList;
import java.util.Comparator;

public class Tenis {
    private String nome;          // Nome do tênis
    public int codigo;            // Código único para o tênis
    private int quantidade;       // Quantidade disponível no estoque
    private double preco;         // Preço do tênis
    public static ArrayList<Tenis> catalogo = new ArrayList<>();  // Lista estática de tênis (catálogo)

    // Construtor para inicializar o tênis
    public Tenis(String nome, int codigo, int quantidade, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e setters para cada atributo
    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido! Definindo como R$ 0.00.");
            this.preco = 0.00;  // Se o preço for inválido, define o preço como R$ 0.00
        }
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade inválida! Definindo como 0.");
            this.quantidade = 0;  // Se a quantidade for inválida (negativa), define como 0
        }
    }

    // Método estático para exibir o catálogo de tênis
    public static void exibirCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("O catálogo está vazio.");
        } else {
            catalogo.sort(Comparator.comparingInt(tenis -> tenis.codigo));  // Ordena os tênis por código (crescente)
            System.out.println("Catálogo de Tênis:");
            for (Tenis tenis : catalogo) {
                System.out.printf("Nome: %-20s | Código: %-10s | Quantidade: %-5d | Preço: R$ %.2f\n", tenis.nome, tenis.codigo, tenis.quantidade, tenis.preco);
            }
        }
    }

    // Método para tratar a compra do tênis com base no código e na quantidade desejada
    public double condicionaisDeCompra(int codigoProduto, int quantidadeProduto, double total) {
        for (Tenis tenis : catalogo) {
            if (tenis.getCodigo() == codigoProduto) { // Se encontrou o produto
                if (tenis.getQuantidade() < quantidadeProduto) { // Se não tem estoque suficiente
                    System.out.println("❌ Erro! Quantidade insuficiente em estoque!");
                    return total; // Mantém o total sem alterações
                }

                // Compra válida, atualiza estoque e total
                double valorCompra = tenis.getPreco() * quantidadeProduto;
                tenis.setQuantidade(tenis.getQuantidade() - quantidadeProduto);
                System.out.println("✅ Adicionado ao carrinho!");

                return total + valorCompra; // Atualiza o total corretamente
            }
        }

        System.out.println("❌ Erro! Código digitado é inválido!");
        return total; // Mantém o total se o código for inválido
    }
}
