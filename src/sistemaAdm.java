package src;

import java.util.Scanner;

public class sistemaAdm {
    public void sistemaAdm() {

        Scanner scanner = new Scanner(System.in);
        int auxI = 0;

        do {
            System.out.println("Sistema E-commerce");
            System.out.println("1 - Cadastrar Produtos");
            System.out.println("2 - Remover Produtos");
            System.out.println("3 - Remover Clientes");
            System.out.println("4 - Adicionar Administrador");
            System.out.println("5 - Sair");

            auxI = scanner.nextInt();

            switch (auxI) {
                case 1:
                    cadastrarProduto(scanner);
                    break;
                case 2:
                    //Remover Produtos
                    break;
                case 3:
                    //Remover Clientes
                    break;
                case 4:
                    //Adicionar Administrador
                case 5:
                    //Sair
                default:
                    System.out.println("Erro! numero digitado é invalido");
            }
        } while (auxI >= 6 || auxI <= 0); //prova real
    }

    public void cadastrarProduto(Scanner scanner){

        int escolhaCadatro = 0;

            System.out.println("\n--- Cadastro de Produtos ---");
            System.out.print("Nome do tênis: ");
            String nome = scanner.nextLine();

            System.out.print("Preço: R$ ");
            double preco = scanner.nextDouble();

            System.out.print("Código: ");
            int codigo = scanner.nextInt();

            System.out.print("Quantidade em estoque: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            // Criando o objeto e adicionando no ArrayList
            //catalogo.add(new Tenis(nome, preco, codigo, quantidade));
            System.out.println("✅ Tênis cadastrado com sucesso!");

            escolhaCadatro = scanner.nextInt();
    }
}
