package sistema;

import produtos.Tenis;

import java.util.ArrayList;
import java.util.Scanner;

import static produtos.Tenis.catalogo;

public class SistemaAdm {
    public void sistemaAdm() {

        Scanner scanner = new Scanner(System.in);
        int auxI = 0;

        do {
            System.out.println("\nSistema E-commerce");
            System.out.println("1 - Cadastrar Produtos");//feito
            System.out.println("2 - Remover Produtos");//feito
            System.out.println("3 - Remover Clientes");//feito?
            System.out.println("4 - Adicionar Administrador");//...
            System.out.println("5 - Listar Produtos");//feito
            System.out.println("6 - Sair");//feito

            auxI = scanner.nextInt();

            switch (auxI) {
                case 1:
                    cadastrarProduto(scanner);
                    break;
                case 2:
                    System.out.println("\n--- Remover Produto ---");
                    System.out.print("Digite código do tênis: ");
                    int codigoRemover = scanner.nextInt();
                    removerProduto(codigoRemover);
                    break;
                case 3:
                    removerCliente(scanner);
                    break;
                case 4:
                    adicionarAdm(scanner);
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 6:
                    sistema.SistemaUsuario sU = new sistema.SistemaUsuario();
                    sU.sistemaUsuario();
                    break;
                default:
                    System.out.println("❌ Erro! Número digitado é inválido.");
            }
        } while (auxI != 6);

    }

    public void listarProdutos() {
        System.out.println("\n--- Produtos Cadastrados ---");
        for (Tenis t : catalogo) {
            System.out.printf("Nome: %-20s | Código: %-10s | Quantidade: %-5d | Preço: R$ %.2f\n", t.getNome(), t.getCodigo(), t.getQuantidade(), t.getPreco());
        }
    }
        public void removerProduto(int codigoRemover) {
        boolean encontrado = false;

            for(Tenis tenis: catalogo){
                if(tenis.getCodigo()== codigoRemover){
                    catalogo.remove(tenis);
                    System.out.println("✅ Tênis removido com sucesso!");
                    encontrado = true;
                    break; // Para de procurar após remover
                }

            }

        if (!encontrado) {
            System.out.println("❌ Código não encontrado!");
        }
    }

    public void cadastrarProduto(Scanner scanner) {
        int continuarCadastro =0;

        do {
            System.out.println("\n--- Cadastro de Produtos ---");
            System.out.print("Nome do tênis: ");
            scanner.nextLine(); // Limpar buffer
            String nome = scanner.nextLine();

            System.out.print("Preço: R$ ");
            double preco = scanner.nextDouble();

            System.out.print("Código: ");
            int codigo = scanner.nextInt();

            System.out.print("Quantidade em estoque: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            Tenis novoTenis = new Tenis(nome, codigo, quantidade, preco);
            catalogo.add(novoTenis);

            System.out.println("✅ Tênis cadastrado com sucesso!");

            System.out.println("Deseja cadastrar outro tênis? 1 - Sim / 2 - Não");
            continuarCadastro = scanner.nextInt();

        } while (continuarCadastro == 1);
    }



    public void removerCliente(Scanner scanner){

        System.out.println("\n--- Remover Cliente---");
        System.out.print("Nome do cliente: ");
        String nomeClienteRemover = scanner.nextLine();
        System.out.print("Senha do cliente: ");
        int senhaClienteRemover = scanner.nextInt();
        removerCliente(scanner);
    }

    public void adicionarAdm(Scanner scanner){



        System.out.print("Digite seu nome: ");
        String nomeAdm = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idadeAdm = scanner.nextInt();

        System.out.print("Digite seu CEP: ");
        int cepAdm = scanner.nextInt();

        System.out.print("Digite sua senha (número): ");
        int senhaAdm = scanner.nextInt();

        System.out.println("Cadastro do Administrador realizado com sucesso");

        Administrador novoAdm = new Administrador();

        novoAdm.setNome(nomeAdm);
        novoAdm.setIdade(idadeAdm);
        novoAdm.setCep(cepAdm);
        novoAdm.setSenha(senhaAdm);

        listaAdm.add(novoAdm);

    }

}
