
package sistema;

import cliente.Cliente;
import cliente.ClientedeAtacado;
import produtos.Tenis;

import java.util.Scanner;

import static produtos.Tenis.catalogo;

public class SistemaAdm {
    public void sistemaAdm() {

        Scanner scanner = new Scanner(System.in);
        Administrador adm = new Administrador();
        Cliente cliente = new Cliente();
        ClientedeAtacado clienteAtacado = new ClientedeAtacado();
        Tenis tenis = new Tenis(null, 0, 0, 0);

        int auxI = 0;
        int contador = 0;

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
            scanner.nextLine(); // Consumir quebra de linha

            switch (auxI) {
                case 1:
                    cadastrarProduto(scanner);
                    break;
                case 2:
                    if (tenis.getNome() == null || tenis.getNome().isEmpty()) {
                        System.out.println("Nenhum produto foi cadastrado.");
                        break;
                    }
                    System.out.println("\n--- Remover Produto ---");
                    System.out.print("Digite o código do produto: ");
                    int codigoRemover = scanner.nextInt();
                    removerProduto(codigoRemover);
                    break;
                case 3:
                    if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
                        System.out.println("Nenhum cliente foi criado.");
                        break;
                    }
                    removerCliente(scanner);
                    break;
                case 4:
                    adm.adicionarAdm(scanner);
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

                    boolean encontrado = false;
                    for (Administrador direcao : adm.listaAdm) {
                        if (direcao.getNome().equals(nomeAdmRemover) && direcao.getSenha() == senhaAdmRemover) {
                            adm.listaAdm.remove(direcao);
                            System.out.println("✅ Administrador removido com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("❌ Erro! Administrador não encontrado ou senha incorreta.");
                    }
                    break;
                case 6:
                    System.out.println("\n=== Lista de Administradores ===");

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
                    listarProdutos();
                    break;
                case 8:
                    sistema.SistemaUsuario sU = new sistema.SistemaUsuario();
                    sU.sistemaUsuario();
                    break;
                case 9:
                    System.out.println("\n--- Cadastro de Cliente ---");
                    System.out.println("1 - Cliente Varejo");
                    System.out.println("2 - Cliente Atacado");
                    System.out.println("3 - Voltar");
                    System.out.print("Escolha uma opção: ");
                    int tipoCadastro = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha

                    switch (tipoCadastro) {
                        case 1:
                            cliente.cadastrarCliente(scanner);
                            System.out.println("✅ Cadastro de Cliente Varejo concluído.");
                            break;
                        case 2:
                            clienteAtacado.cadastrarCliente(scanner);
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ Opção inválida! Escolha um número entre 1 e 11.");
            }
        } while (auxI != 11);


    }

    public void listarProdutos() {
        System.out.println("\n--- Produtos Cadastrados ---");
        for (Tenis t : catalogo) {
            System.out.printf("Nome: %-20s | Código: %-10s | Quantidade: %-5d | Preço: R$ %.2f\n", t.getNome(), t.getCodigo(), t.getQuantidade(), t.getPreco());
        }
    }

    public void removerProduto(int codigoRemover) {
        boolean encontrado = false;

        for (Tenis tenis : catalogo) {
            if (tenis.getCodigo() == codigoRemover) {
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

            for (Tenis tenis : catalogo) {
                if (tenis.getCodigo() == codigo) {
                    codigoExistente = true;
                    break;
                }
            }

            if (codigoExistente) {
                System.out.println("Erro! código igual a um produto já existente");
                System.out.println("Codigos usados:1,2,3");
                return;
            }


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

}
