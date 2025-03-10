package sistema;

import cliente.Cliente;
import cliente.ClientedeAtacado;
import produtos.Tenis;

import java.util.Scanner;

import static produtos.Tenis.catalogo;

public class SistemaAdm {
    // Método principal para administrar o sistema e-commerce
    public void sistemaAdm() {

        // Instanciando as classes necessárias
        Scanner scanner = new Scanner(System.in);  // Scanner para capturar entradas do usuário
        Administrador adm = new Administrador();  // Objeto para o administrador
        Cliente cliente = new Cliente();  // Cliente Varejo
        ClientedeAtacado clienteAtacado = new ClientedeAtacado();  // Cliente Atacado
        Tenis tenis = new Tenis(null, 0, 0, 0);  // Objeto para representar o produto (Tênis)

        int auxI = 0;
        int contador = 0;

        // Loop principal para o menu de administração
        do {
            System.out.println("\n=== Sistema E-commerce ===");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Adicionar Administrador");
            System.out.println("5 - Remover Administrador");
            System.out.println("6 - Listar Administradores");
            System.out.println("7 - Listar Produtos");
            System.out.println("8 - Acessar Sistema de Usuário");
            System.out.println("9 - Cadastrar Cliente");
            System.out.println("10 - Listar Clientes");
            System.out.println("11 - Encerrar Programa");
            System.out.print("Escolha uma opção: ");

            auxI = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de entrada

            // Switch para lidar com as opções do menu de administração
            switch (auxI) {
                case 1:
                    cadastrarProduto(scanner);  // Chama o método para cadastrar um produto
                    break;
                case 2:
                    if (tenis.getNome() == null || tenis.getNome().isEmpty()) {
                        System.out.println("Nenhum produto foi cadastrado.");
                        break;
                    }
                    System.out.println("\n--- Remover Produto ---");
                    System.out.print("Digite o código do produto: ");
                    int codigoRemover = scanner.nextInt();
                    removerProduto(codigoRemover);  // Chama o método para remover um produto
                    break;
                case 3:
                    if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
                        System.out.println("Nenhum cliente foi criado.");
                        break;
                    }
                    removerCliente(scanner);  // Chama o método para remover um cliente
                    break;
                case 4:
                    adm.adicionarAdm(scanner);  // Chama o método para adicionar um novo administrador
                    break;
                case 5:
                    if (adm.getNome() == null || adm.getNome().isEmpty()) {
                        System.out.println("Nenhum adm foi criado.");
                        break;
                    }
                    System.out.println("\n--- Remover Administrador ---");
                    System.out.print("Nome do Administrador: ");
                    String nomeAdmRemover = scanner.nextLine();
                    System.out.print("Senha do Administrador: ");
                    int senhaAdmRemover = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha

                    // Tenta encontrar o administrador com o nome e senha fornecidos
                    boolean encontrado = false;
                    for (Administrador direcao : adm.listaAdm) {
                        if (direcao.getNome().equals(nomeAdmRemover) && direcao.getSenha() == senhaAdmRemover) {
                            adm.listaAdm.remove(direcao);  // Remove o administrador encontrado
                            System.out.println("✅ Administrador removido com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }

                    // Caso o administrador não seja encontrado
                    if (!encontrado) {
                        System.out.println("❌ Erro! Administrador não encontrado ou senha incorreta.");
                    }
                    break;
                case 6:
                    System.out.println("\n=== Lista de Administradores ===");

                    // Verifica se existem administradores cadastrados
                    if (adm.listaAdm.isEmpty()) {
                        System.out.println("Nenhum administrador cadastrado.");
                    } else {
                        for (Administrador d : adm.listaAdm) {
                            System.out.printf("Nome: %s | Senha: %s | Cep: %s | Idade: %d%n",
                                    d.getNome(), d.getSenha(), d.getCep(), d.getIdade());
                        }
                    }
                    break;
                case 7:
                    listarProdutos();  // Chama o método para listar os produtos cadastrados
                    break;
                case 8:
                    sistema.SistemaUsuario sU = new sistema.SistemaUsuario();
                    sU.sistemaUsuario();  // Chama o sistema de usuários
                    break;
                case 9:
                    System.out.println("\n--- Cadastro de Cliente ---");
                    System.out.println("1 - Cliente Varejo");
                    System.out.println("2 - Cliente Atacado");
                    System.out.println("3 - Voltar");
                    System.out.print("Escolha uma opção: ");
                    int tipoCadastro = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    // Switch para selecionar o tipo de cadastro
                    switch (tipoCadastro) {
                        case 1:
                            cliente.cadastrarCliente(scanner);  // Chama o método para cadastrar cliente varejo
                            System.out.println("✅ Cadastro de Cliente Varejo concluído.");
                            break;
                        case 2:
                            clienteAtacado.cadastrarCliente(scanner);  // Chama o método para cadastrar cliente atacado
                            System.out.println("✅ Cadastro de Cliente Atacado concluído.");
                            break;
                        case 3:
                            System.out.println("Voltando ao menu...");
                            break;
                        default:
                            System.out.println("❌ Opção inválida! Escolha 1, 2 ou 3.");
                    }
                    break;
                case 10:
                    System.out.println("\n=== Lista de Clientes ===");
                    // Exibe a lista de clientes cadastrados
                    if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
                        System.out.println("Nenhum cliente foi cadastrado.");
                        break;
                    }
                    for (Cliente c : Cliente.catalogoCliente) {
                        System.out.println("Nome: " + c.getNome() + " | Idade: " + c.getIdade() + " | CEP: " + c.getCep());
                    }
                    for (ClientedeAtacado ca : ClientedeAtacado.catalogoClienteAtacado) {
                        System.out.println("Nome: " + ca.getNome() + " | Idade: " + ca.getIdade() + " | CEP: " + ca.getCep() + " | CNPJ: " + ca.getCnpj() + " | Desconto especial: " + ca.getDescontoEspecial());
                    }
                    break;
                case 11:
                    System.out.println("Encerrando programa..");
                    System.exit(0);  // Encerra o programa
                    break;
                default:
                    System.out.println("❌ Opção inválida! Escolha um número entre 1 e 11.");
            }
        } while (auxI != 11);  // Loop continuará até que a opção 11 seja selecionada (encerrar programa)
    }

    // Método para listar todos os produtos cadastrados
    public void listarProdutos() {
        System.out.println("\n--- Produtos Cadastrados ---");
        for (Tenis t : catalogo) {
            System.out.printf("Nome: %-20s | Código: %-10s | Quantidade: %-5d | Preço: R$ %.2f\n", t.getNome(), t.getCodigo(), t.getQuantidade(), t.getPreco());
        }
    }

    // Método para remover um produto
    public void removerProduto(int codigoRemover) {
        boolean encontrado = false;

        for (Tenis tenis : catalogo) {
            if (tenis.getCodigo() == codigoRemover) {
                catalogo.remove(tenis);  // Remove o produto com o código correspondente
                System.out.println("✅ Tênis removido com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("❌ Código não encontrado!");  // Caso o código do produto não seja encontrado
        }
    }

    // Método para cadastrar um novo produto
    public void cadastrarProduto(Scanner scanner) {
        int continuarCadastro = 0;

        do {
            System.out.println("\n--- Cadastro de Produtos ---");
            System.out.print("Nome do tênis: ");
            String nome = scanner.nextLine();

            System.out.print("Preço: R$ ");
            double preco = scanner.nextDouble();

            System.out.print("Código: ");
            int codigo = scanner.nextInt();

            boolean codigoExistente = false;

            // Verifica se o código do produto já existe
            for (Tenis tenis : catalogo) {
                if (tenis.getCodigo() == codigo) {
                    codigoExistente = true;
                    break;
                }
            }

            // Caso o código já exista
            if (codigoExistente) {
                System.out.println("Erro! código igual a um produto já existente");
                return;
            }

            System.out.print("Quantidade em estoque: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            // Criação do novo produto e adição ao catálogo
            Tenis novoTenis = new Tenis(nome, codigo, quantidade, preco);
            catalogo.add(novoTenis);

            System.out.println("✅ Tênis cadastrado com sucesso!");

            // Pergunta se deseja cadastrar outro produto
            System.out.println("Deseja cadastrar outro tênis? 1 - Sim / 2 - Não");
            continuarCadastro = scanner.nextInt();

        } while (continuarCadastro == 1);  // Loop para continuar cadastrando produtos
    }

    // Método para remover um cliente
    public void removerCliente(Scanner scanner) {
        System.out.println("\n--- Remover Cliente---");
        System.out.print("Nome do cliente: ");
        String nomeClienteRemover = scanner.nextLine();
        System.out.print("Senha do cliente: ");
        int senhaClienteRemover = scanner.nextInt();
        // Lógica de remoção de cliente não implementada completamente, já que o método recursivamente chama a si mesmo
        removerCliente(scanner);
    }

}
