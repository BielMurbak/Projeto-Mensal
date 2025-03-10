package sistema;

import cliente.Cliente;
import cliente.ClientedeAtacado;
import cliente.Login;
import produtos.Tenis;

import java.util.Scanner;

import static produtos.Tenis.catalogo;

public class Main {
    public static void main(String[] args) {

        // Instanciando as classes necessárias
        Scanner scanner = new Scanner(System.in); // Scanner para capturar entradas do usuário

        Cliente cliente = new Cliente();  // Cliente do tipo Varejo
        ClientedeAtacado clienteAtacado = new ClientedeAtacado();  // Cliente do tipo Atacado
        Login login = new Login();  // Objeto para controle de login
        sistema.Administrador adm = new sistema.Administrador();  // Administrador do sistema

        // Adicionando produtos (Tênis) ao catálogo
        catalogo.add(new Tenis("Nike Air Max", 1, 10, 499.99)); // Produto 1
        catalogo.add(new Tenis("Adidas Ultra Boost", 2, 5, 599.99)); // Produto 2
        catalogo.add(new Tenis("Puma RS-X", 3, 8, 349.99)); // Produto 3

        // Variáveis auxiliares para controle de fluxo
        int aux = 0;
        String auxB;
        int tipo = 0;

        // Loop principal para o menu do sistema
        do {
            System.out.println("\n");
            System.out.println("---Sistema e-commerce---");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Encerrar programa");
            System.out.println("Escolha uma opção:");
            aux = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            // Switch para lidar com as opções do menu
            switch (aux) {
                case 1:
                    System.out.println("\n");
                    System.out.println("Escolha o tipo de usuário para login:");
                    System.out.println("1 - Cliente Varejo");
                    System.out.println("2 - Cliente Atacado");
                    System.out.println("3 - Administrador");
                    System.out.print("Digite a opção desejada: ");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine();  // Limpa o buffer após nextInt()

                    // Switch para verificar qual tipo de usuário está tentando fazer login
                    switch (tipoUsuario) {
                        case 1: // Login para Cliente Varejo
                            if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
                                System.out.println("❌ Erro! Nenhum cliente cadastrado. Cadastre-se primeiro antes de tentar logar.");
                                continue; // Retorna ao menu principal
                            }

                            // Solicita o nome de login e senha do cliente
                            System.out.println("Digite seu nome de login (Cliente Varejo): ");
                            String nomeLoginVarejo = scanner.nextLine();
                            System.out.println("Digite sua senha de login: ");
                            int senhaLoginVarejo = scanner.nextInt();
                            login.setNomeLogin(nomeLoginVarejo);
                            login.setSenhaLogin(senhaLoginVarejo);
                            login.realizarLoginCliente(cliente); // Realiza o login do cliente varejo
                            break;

                        case 2:  // Login para Cliente Atacado
                            if (clienteAtacado.getCnpj() == 0) {
                                System.out.println("❌ Erro! Nenhum cliente cadastrado. Cadastre-se primeiro antes de tentar logar.");
                                continue; // Retorna ao menu principal
                            }

                            // Solicita o nome de login e senha do cliente atacado
                            System.out.println("Digite seu nome de login (Cliente Atacado): ");
                            String nomeLoginAtacado = scanner.nextLine();
                            System.out.println("Digite sua senha de login: ");
                            int senhaLoginAtacado = scanner.nextInt();
                            login.setNomeLogin(nomeLoginAtacado);
                            login.setSenhaLogin(senhaLoginAtacado);
                            login.realizarLoginClienteAtacado(clienteAtacado); // Realiza o login do cliente atacado
                            break;

                        case 3:  // Login para Administrador
                            // Solicita o nome de login e senha do administrador
                            System.out.println("Digite seu nome de login (Administrador): ");
                            String nomeLoginAdmin = scanner.nextLine();
                            System.out.println("Digite sua senha de login: ");
                            int senhaLoginAdmin = scanner.nextInt();
                            login.setNomeLogin(nomeLoginAdmin);
                            login.setSenhaLogin(senhaLoginAdmin);
                            login.realizarloginAdm(adm); // Realiza o login do administrador
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");  // Caso o tipo de usuário seja inválido
                    }
                    break;

                case 2:  // Cadastro de novos usuários
                    System.out.println("Escolha o tipo de cadastro:");
                    System.out.println("1 - Cliente Varejo");
                    System.out.println("2 - Cliente Atacado");
                    System.out.println("3 - Sair");
                    System.out.print("Digite a opção desejada: ");
                    int tipoCadastro = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    // Switch para lidar com as opções de cadastro
                    switch (tipoCadastro) {
                        case 1:  // Cadastro de Cliente Varejo
                            cliente.cadastrarCliente(scanner);  // Chama o método de cadastro para Cliente Varejo
                            System.out.println("Cadastro de Cliente Varejo concluído.");
                            break;

                        case 2:  // Cadastro de Cliente Atacado
                            clienteAtacado.cadastrarCliente(scanner);  // Chama o método de cadastro para Cliente Atacado
                            break;

                        case 3:
                            System.out.println("Saindo..."); // Sai do sistema
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");  // Caso a opção de cadastro seja inválida
                    }
                    break;

                case 3:  // Encerra o programa
                    System.out.println("Programa Encerrado com sucesso.");
                    System.exit(0);  // Encerra o programa
                    break;

                default:
                    System.out.println("Erro! Número digitado é inválido.");  // Caso a opção digitada seja inválida
            }

        } while (aux != 3);  // O loop continua até que o usuário escolha a opção 3 para encerrar o programa
    }//fecha void main
}//fecha class main
