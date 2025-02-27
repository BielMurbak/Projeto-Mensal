package src;

import java.util.Scanner;

public class SistemaUsuario {
    public void sistemaUsuario() {

        Scanner scanner = new Scanner(System.in);
        int auxI = 0;

        do {
            System.out.println("Sistema E-commerce");
            System.out.println("1-Nossos Produtos");
            System.out.println("2-Carrinho");
            System.out.println("3-Pedido");
            System.out.println("4-Suporte ao Cliente");
            System.out.println("5-Suguraça e Privacidade");
            System.out.println("6-Sair");
            auxI = scanner.nextInt();

            switch (auxI) {
                case 1:
                    //produtos
                    break;
                case 2:
                    //carrinho
                    break;
                case 3:
                    //pedido
                    break;
                case 4:
                    mostrarSuporteAoCliente(scanner);
                case 5:
                   mostrarSegurancaPrivacidade(scanner);
                case 6:
                    System.out.println("Programa foi encerrado com sucesso!");
                    System.exit(0);
                default:
                    System.out.println("Erro! numero digitado é invalido");
            }
        } while (auxI >= 7 || auxI <= 0); //ver se a logica ta certa
    }


    private void mostrarSegurancaPrivacidade(Scanner scanner) {
        int escolhaSegurancaPrivacidade = 0;

        do {
            System.out.println("\n--- Segurança e Privacidade ---");
            System.out.println("1 - Exibir política de privacidade");
            System.out.println("2 - Alterar senha");
            System.out.println("3 - Configurações de segurança");
            System.out.println("4 - Logout");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            escolhaSegurancaPrivacidade = scanner.nextInt();

            switch (escolhaSegurancaPrivacidade) {
                case 1:
                    System.out.println("\nPolítica de Privacidade: \n- Nós respeitamos a sua privacidade e não compartilhamos seus dados com terceiros...");
                    break;
                case 2:
                  //alterar senha
                    break;
                case 3:
                    //configuracoes de seguranca
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Erro! digite uma opcao valida!");

            }

        } while (escolhaSegurancaPrivacidade < 1 || escolhaSegurancaPrivacidade > 5);
    }

    private void mostrarSuporteAoCliente(Scanner scanner) {
        int escolhaSuporte = 0;

        do {
            System.out.println("\n--- Suporte ao Cliente ---");
            System.out.println("1 - FAQ (Perguntas Frequentes)");
            System.out.println("2 - Abrir um ticket de suporte");
            System.out.println("3 - Informações de contato");
            System.out.println("4 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            escolhaSuporte = scanner.nextInt();

            switch (escolhaSuporte) {
                case 1:
                    System.out.println("\nFAQ - Perguntas Frequentes:");
                    System.out.println("1-Como posso realizar um pedido?");
                    System.out.println("Entre em contato conosco para obter mais informações sobre este pedido.");
                    System.out.println("2-Como faço para devolver um produto?");
                    System.out.println("Entre em contato conosco para obter mais informações sobre sua situaçao.");
                    System.out.println("Telefone: 0800-123-456");
                    System.out.println("E-mail: suporte@ecommerce.com");
                    break;
                case 2:
                    System.out.println("\nAbrindo um ticket de suporte...");
                    System.out.println("\nDigite seu nome inteiro:");
                    String nometicket = scanner.nextLine();
                    System.out.println("\nDigite sua duvida ou problema:");
                    String duvida = scanner.nextLine();
                    System.out.println("\nTicket foi enviado com sucesso.");
                    break;
                case 3:
                    System.out.println("\nInformações de Contato:");
                    System.out.println("Telefone: 0800-123-456");
                    System.out.println("E-mail: suporte@ecommerce.com");
                    break;
                case 4:
                    System.out.println("\nVoltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while(escolhaSuporte <1 || escolhaSuporte >4);
    }
}

