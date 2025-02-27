package src;

public class Tenis {
    String nome;
    int codigo;
    int quantidade;
    double preco;

    public Tenis() {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido! Definindo como R$ 0.00.");
            this.preco = 0.00;
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
            this.quantidade = 0;
        }
    }
}

