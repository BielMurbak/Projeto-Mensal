package sistema;

import pessoa.Administrador;
import pessoa.ClienteAtacado;
import pessoa.ClienteVarejo;
import pessoa.ValidadorAcesso;
import produtos.Tenis;

import java.util.Scanner;

import static produtos.Tenis.catalogo;

public class Main {
    public static void main(String[] args) {

        // Instanciando as classes necessárias
        Scanner scanner = new Scanner(System.in); // Scanner para capturar entradas do usuário

        ClienteVarejo clienteVarejo = new ClienteVarejo();  // ClienteVarejo do tipo Varejo
        ClienteAtacado clienteAtacado = new ClienteAtacado();  // ClienteVarejo do tipo Atacado
        ValidadorAcesso validadorAcesso = new ValidadorAcesso();  // Objeto para controle de validadorAcesso
        Administrador adm = new Administrador();  // Administrador do sistema

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
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Encerrar programa");
            System.out.println("Escolha uma opção:");
            aux = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            // Switch para lidar com as opções do menu
            switch (aux) {
                case 1:
                    System.out.println("\n");
                    System.out.println("Escolha o tipo de usuário para validadorAcesso:");
                    System.out.println("1 - Cliente de Varejo");
                    System.out.println("2 - Cliente de Atacado");
                    System.out.println("3 - Administrador");
                    System.out.print("Digite a opção desejada: ");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine();  // Limpa o buffer após nextInt()

                    // Switch para verificar qual tipo de usuário está tentando fazer validadorAcesso
                    switch (tipoUsuario) {
                        case 1: // ValidadorAcesso para ClienteVarejo Varejo
                            if (clienteVarejo.getNome() == null || clienteVarejo.getNome().isEmpty()) {
                                System.out.println("❌ Erro! Nenhum cliente de Varejo cadastrado. Cadastre-se primeiro antes de tentar logar.");
                                continue; // Retorna ao menu principal
                            }

                            // Solicita o nome de validadorAcesso e senha do clienteVarejo
                            System.out.println("Digite seu nome de validadorAcesso (Cliente de Varejo): ");
                            String nomeLoginVarejo = scanner.nextLine();
                            System.out.println("Digite sua senha de validador Acesso: ");
                            int senhaLoginVarejo = scanner.nextInt();
                            validadorAcesso.setNomeLogin(nomeLoginVarejo);
                            validadorAcesso.setSenhaLogin(senhaLoginVarejo);
                            validadorAcesso.realizarLoginCliente(clienteVarejo); // Realiza o validadorAcesso do clienteVarejo varejo
                            break;

                        case 2:  // ValidadorAcesso para ClienteVarejo Atacado
                            if (clienteAtacado.getCnpj() == 0) {
                                System.out.println("❌ Erro! Nenhum clienteVarejo cadastrado. Cadastre-se primeiro antes de tentar logar.");
                                continue; // Retorna ao menu principal
                            }

                            // Solicita o nome de validadorAcesso e senha do clienteVarejo atacado
                            System.out.println("Digite seu nome de validadorAcesso (Cliente de  Atacado): ");
                            String nomeLoginAtacado = scanner.nextLine();
                            System.out.println("Digite sua senha de validadorAcesso: ");
                            int senhaLoginAtacado = scanner.nextInt();
                            validadorAcesso.setNomeLogin(nomeLoginAtacado);
                            validadorAcesso.setSenhaLogin(senhaLoginAtacado);
                            validadorAcesso.realizarLoginClienteAtacado(clienteAtacado); // Realiza o validadorAcesso do clienteVarejo atacado
                            break;

                        case 3:  // ValidadorAcesso para Administrador
                            // Solicita o nome de validadorAcesso e senha do administrador
                            System.out.println("Digite seu nome de validadorAcesso (Administrador): ");
                            String nomeLoginAdmin = scanner.nextLine();
                            System.out.println("Digite sua senha de validadorAcesso: ");
                            int senhaLoginAdmin = scanner.nextInt();
                            validadorAcesso.setNomeLogin(nomeLoginAdmin);
                            validadorAcesso.setSenhaLogin(senhaLoginAdmin);
                            validadorAcesso.realizarloginAdm(adm); // Realiza o validadorAcesso do administrador
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");  // Caso o tipo de usuário seja inválido
                    }
                    break;

                case 2:  // Cadastro de novos usuários
                    System.out.println("Escolha o tipo de cadastro:");
                    System.out.println("1 - Cliente de Varejo");
                    System.out.println("2 - Cliente de Atacado");
                    System.out.println("3 - Sair");
                    System.out.print("Digite a opção desejada: ");
                    int tipoCadastro = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    // Switch para lidar com as opções de cadastro
                    switch (tipoCadastro) {
                        case 1:  // Cadastro de ClienteVarejo Varejo
                            clienteVarejo.cadastrarCliente(scanner);  // Chama o método de cadastro para ClienteVarejo Varejo
                            System.out.println("Cadastro de Cliente de Varejo concluído.");
                            break;

                        case 2:  // Cadastro de ClienteVarejo Atacado
                            clienteAtacado.cadastrarCliente(scanner);  // Chama o método de cadastro para ClienteVarejo Atacado
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
