package sistema;

import cliente.Cliente;
import cliente.ClientedeAtacado;
import cliente.Login;
import org.json.JSONException;
import org.json.JSONObject;
import pagamento.*;
import pedidos.StatusPedido;
import produtos.Tenis;
import frete.Frete;
import frete.FretePadrao;
import frete.FreteExpresso;
import frete.SeguroFrete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static cliente.Cliente.catalogoCliente;
import static cliente.ClientedeAtacado.catalogoClienteAtacado;
import static produtos.Tenis.*;

public class SistemaUsuario {

    private double total = 0;

    public void sistemaUsuario() {

        Scanner scanner = new Scanner(System.in); // Leitura de entradas do usuário
        Tenis tenis = new Tenis(null, 0, 0, 0); // Instanciação do objeto Tenis
        List<Tenis> carrinho = new ArrayList<>(); // Lista para armazenar os tênis no carrinho de compras
        StatusPedido statusPedido = StatusPedido.PROCESSANDO; // Status do pedido (inicialmente PROCESSANDO)

        // Instâncias de pagamento para diferentes métodos
        Pagamento pagamentoCredito = new pagamento.CartaoDeCredito();
        Pagamento pagamentoDebito = new pagamento.CartaoDebito();
        Pagamento pagamentoPix = new pagamento.Pix();
        Pagamento pagamentoDinheiro = new pagamento.Dinheiro();
        Cliente cliente = new Cliente(); // Cliente normal
        ClientedeAtacado clienteAtacado = new ClientedeAtacado(); // Cliente de atacado

        Login login = new Login(); // Instanciação do login
        sistema.Endereco Endereco = new Endereco(); // Instanciação de endereço
        Cliente novoCliente = new Cliente(); // Novo cliente

        int auxI = 0;
        int continuarCadastro = 0;

        do {
            System.out.println("\n");
            // Exibição dos dados de cada cliente do catálogo (apenas nome e senha)
            for (Cliente cliente2 : catalogoCliente) {
                System.out.println("Nome: " + cliente2.getNome());
                System.out.println("Senha: " + cliente2.getSenha());
            }
            // Menu principal
            System.out.println("Sistema E-commerce");
            System.out.println("1 - Nossos Produtos");
            System.out.println("2 - Suporte ao Cliente");
            System.out.println("3 - Seguraça e Privacidade");
            System.out.println("4 - Sair");
            auxI = scanner.nextInt(); // Escolha do usuário no menu principal

            switch (auxI) {
                case 1:
                    do {
                        exibirCatalogo(); // Exibição do catálogo de produtos
                        System.out.println("Digite código do produto:");
                        int codigoProduto = scanner.nextInt();
                        System.out.println("Digite a quantidade: ");
                        int quantidadeProduto = scanner.nextInt();

                        tenis.condicionaisDeCompra(codigoProduto, quantidadeProduto, total); // Condicionais de compra do produto

                        // Laço para adicionar o produto escolhido ao carrinho e atualizar o total
                        for (Tenis t : catalogo) {
                            if (t.getCodigo() == codigoProduto) {
                                // Criar um novo objeto Tenis com a quantidade comprada
                                Tenis compra = new Tenis(t.getNome(), t.getCodigo(), quantidadeProduto, t.getPreco());
                                carrinho.add(compra); // Adiciona o tênis ao carrinho

                                // Atualiza o total com a multiplicação do preço pela quantidade
                                total += compra.getPreco() * quantidadeProduto;
                            }
                        }

                        // Pergunta se o usuário deseja comprar mais produtos
                        System.out.println("Deseja comprar outro tênis? 1 - Sim / 2 - Não");
                        continuarCadastro = scanner.nextInt();
                    } while (continuarCadastro == 1); // Continuação até o usuário escolher parar de comprar

                    // Exibe todos os produtos no carrinho
                    for (Tenis item : carrinho) {
                        System.out.println("Produto: " + item.getNome() + " | Código: " + item.getCodigo() + " | Quantidade: " + item.getQuantidade() + " | Preço Unitário: R$ " + item.getPreco());
                    }
                    System.out.println("Total:" + total);
                    System.out.println("---- Pagamento ----");
                    // Menu de opções de pagamento
                    System.out.println("1-Cartao de Credito");
                    System.out.println("2-Cartao de Debito");
                    System.out.println("3-Pix");
                    System.out.println("4-Dinheiro");
                    System.out.print("Digite sua opcao:");
                    int opcaoPagamento = scanner.nextInt();

                    // Processamento do pagamento conforme a opção escolhida
                    if (opcaoPagamento == 1) {
                        pagamentoCredito.realizarPagamento(total); // Realiza pagamento com Cartão de Crédito
                        apiCep(scanner); // Chama a API de CEP para obter o endereço de entrega
                    } else if (opcaoPagamento == 2) {
                        pagamentoDebito.realizarPagamento(total); // Realiza pagamento com Cartão de Débito
                        Extrato extrato = new Extrato(pagamentoDebito, total);
                        extrato.exibirExtrato(opcaoPagamento, total); // Exibe o extrato
                        apiCep(scanner); // Chama a API de CEP
                    } else if (opcaoPagamento == 3) {
                        pagamentoPix.realizarPagamento(total); // Realiza pagamento via Pix
                        Extrato extrato = new Extrato(pagamentoPix, total);
                        extrato.exibirExtrato(opcaoPagamento, total);
                        apiCep(scanner);
                    } else if (opcaoPagamento == 4) {
                        pagamentoDinheiro.realizarPagamento(total); // Realiza pagamento em Dinheiro
                        Extrato extrato = new Extrato(pagamentoDinheiro, total);
                        extrato.exibirExtrato(opcaoPagamento, total);
                        apiCep(scanner);
                    } else {
                        System.out.println("Erro! Número digitado é inválido.");
                    }

                    // Verifica se o total é válido
                    if (total <= 0) {
                        System.out.println("❌Erro! Você não fez nenhuma compra.");
                        sistemaUsuario(); // Reinicia o sistema caso o total seja zero ou negativo
                        break;
                    }

                    // Exibe os detalhes finais da compra
                    for (Tenis item : carrinho) {
                        System.out.println("Produto: " + item.getNome() + " | Código: " + item.getCodigo() + " | Quantidade: " + item.getQuantidade() + " | Preço Unitário: R$ " + item.getPreco());
                    }
                    System.out.println("Total:" + total);
                    break;
                case 2:
                    mostrarSuporteAoCliente(scanner); // Exibe a seção de suporte ao cliente
                    break;
                case 3:
                    mostrarSegurancaPrivacidade(scanner); // Exibe a seção de segurança e privacidade
                    break;
                case 4:
                    System.out.println("Programa foi encerrado com sucesso!"); // Finaliza o programa
                    System.exit(0);
                default:
                    System.out.println("Erro! número digitado é invalido"); // Mensagem de erro caso a opção escolhida não seja válida
            }
        } while (auxI < 1 || auxI > 6); // Loop para continuar até o usuário selecionar uma opção válida
    }

    private void mostrarSegurancaPrivacidade(Scanner scanner) {
        int escolhaSegurancaPrivacidade = 0;

        do {
            System.out.println("\n--- Segurança e Privacidade ---");
            // Exibe as opções de segurança e privacidade
            System.out.println("1 - Exibir política de privacidade");
            System.out.println("2 - Alterar senha");
            System.out.println("3 - Alterar nome");
            System.out.println("4 - Logout");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            escolhaSegurancaPrivacidade = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            switch (escolhaSegurancaPrivacidade) {
                case 1:
                    System.out.println("\nPolítica de Privacidade: \n- Nós respeitamos a sua privacidade e não compartilhamos seus dados com terceiros...");
                    mostrarSegurancaPrivacidade(scanner); // Exibe novamente as opções
                    break;

                case 2:
                    System.out.println("Digite o seu nome:");
                    String nomeCliente = scanner.nextLine();

                    System.out.println("Digite a senha atual:");
                    int senhaAtual = scanner.nextInt();

                    System.out.println("Digite a nova senha:");
                    int novaSenha = scanner.nextInt();
                    scanner.nextLine();

                    // Tenta alterar a senha do cliente
                    boolean senhaAlterada = Cliente.alterarSenha(nomeCliente, senhaAtual, novaSenha);
                    if (senhaAlterada) {
                        sistemaUsuario(); // Reinicia o sistema após alteração bem-sucedida
                        return;
                    } else {
                        System.out.println("Falha ao alterar a senha.");
                        mostrarSegurancaPrivacidade(scanner); // Exibe novamente as opções
                    }

                    break;

                case 3:
                    System.out.println("Digite o seu nome:");
                    String nomeCliente2 = scanner.nextLine();

                    System.out.println("Digite a senha atual:");
                    int senhaAtual2 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();

                    // Tenta alterar o nome do cliente
                    boolean nomeAlterada = Cliente.alterarNome(nomeCliente2, senhaAtual2, novoNome);
                    if (nomeAlterada) {
                        System.out.println("O nome foi alterado com sucesso.");
                        sistemaUsuario(); // Reinicia o sistema após alteração bem-sucedida
                        break;

                    } else {
                        System.out.println("Falha ao alterar o nome.");
                        mostrarSegurancaPrivacidade(scanner); // Exibe novamente as opções
                    }
                    break;

                case 4:
                    // Pergunta ao usuário se deseja realizar logout
                    System.out.println("\nDeseja continuar com o logout? (1 - Sim / 2 - Não): ");
                    int opLogout = scanner.nextInt();

                    if (opLogout == 1) {
                        // Limpa os dados dos clientes quando realizar o logout
                        for (Cliente cliente : catalogoCliente) {
                            cliente.setNome(null);
                            cliente.setIdade(0);
                            cliente.setCep(0);
                            cliente.setSenha(0);
                        }
                        for (ClientedeAtacado clientedeAtacado : catalogoClienteAtacado) {
                            clientedeAtacado.setCnpj(0);
                            clientedeAtacado.setDescontoEspecial(0);
                        }
                        System.out.println("🔐 Logout realizado com sucesso!");
                        Main principal = new Main();
                        principal.main(null);  // Reinicia o sistema principal após o logout
                    } else if (opLogout == 2) {
                        // Caso o usuário não queira fazer o logout, o sistema retorna
                        return;
                    } else {
                        // Caso o usuário digite uma opção inválida
                        System.out.println("Erro! Número digitado inválido.");
                    }

                    break;

                case 5:
                    // Caso o usuário escolha voltar ao menu principal
                    System.out.println("🔙 Voltando ao menu principal...");
                    sistemaUsuario();  // Chama o método que volta ao menu principal
                    break;

                default:
                    // Caso o usuário digite uma opção inválida
                    System.out.println("Erro! Digite uma opção válida!");
            }

        } while (escolhaSegurancaPrivacidade < 1 || escolhaSegurancaPrivacidade > 5);  // Loop continua até a escolha ser válida
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

            scanner.nextLine();  // Limpa o buffer para evitar leitura incorreta

            switch (escolhaSuporte) {
                case 1:
                    // Exibe perguntas frequentes (FAQ)
                    System.out.println("\nFAQ - Perguntas Frequentes:");
                    System.out.println("1-Como posso realizar um pedido?");
                    System.out.println("Entre em contato conosco para obter mais informações sobre este pedido.");
                    System.out.println("2-Como faço para devolver um produto?");
                    System.out.println("Entre em contato conosco para obter mais informações sobre sua situação.");
                    System.out.println("Telefone: 0800-123-456");
                    System.out.println("E-mail: suporte@ecommerce.com");
                    mostrarSuporteAoCliente(scanner);  // Chama novamente a função para mostrar as opções
                case 2:
                    // Permite ao usuário abrir um ticket de suporte
                    System.out.println("\nAbrindo um ticket de suporte...");
                    System.out.println("\nDigite seu nome inteiro:");
                    String nometicket = scanner.nextLine();
                    System.out.println("\nDigite sua dúvida ou problema:");
                    String duvida = scanner.nextLine();
                    System.out.println("\nTicket foi enviado com sucesso.");
                    mostrarSuporteAoCliente(scanner);  // Chama novamente para exibir as opções
                    break;
                case 3:
                    // Exibe informações de contato do suporte
                    System.out.println("\nInformações de Contato:");
                    System.out.println("Telefone: 0800-123-456");
                    System.out.println("E-mail: suporte@ecommerce.com");
                    mostrarSuporteAoCliente(scanner);  // Chama novamente para mostrar as opções
                    break;
                case 4:
                    // Volta ao menu principal
                    System.out.println("\nVoltando ao menu principal...");
                    sistemaUsuario();  // Chama o método que volta ao menu principal
                    break;
                default:
                    // Caso a opção seja inválida
                    System.out.println("Opção inválida. Tente novamente.");
                    mostrarSuporteAoCliente(scanner);  // Chama novamente para mostrar as opções
            }
        } while (escolhaSuporte < 1 || escolhaSuporte > 4);  // Loop continua até a escolha ser válida
    }

    // Função para buscar e processar o CEP do usuário
    private void apiCep(Scanner scanner) {
        System.out.println("\n");
        System.out.println("---- Escolha a opção de recebimento ----");
        System.out.println("1 - Entrega");
        System.out.println("2 - Retirada na loja");
        System.out.println("3 - Sair");
        System.out.print("Digite sua opção: ");
        int opcaoRecebimento = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer após o nextInt()
        StatusPedido statusPedido = StatusPedido.PROCESSANDO;  // Define o status inicial como PROCESSANDO

        if (opcaoRecebimento == 1) {
            // Caso o usuário escolha a opção de entrega
            System.out.print("Informe o cep:");
            String cep = scanner.nextLine();

            try {
                // Conecta-se à API do ViaCEP para obter os dados de endereço
                String url = "https://viacep.com.br/ws/" + cep + "/json/";

                HttpURLConnection conexao = (HttpURLConnection) new URL(url).openConnection();
                conexao.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                StringBuilder resposta = new StringBuilder();
                String linha;

                while ((linha = reader.readLine()) != null) {
                    resposta.append(linha);  // Lê e concatena as linhas da resposta
                }
                reader.close();

                // Converte a resposta para um objeto JSON
                JSONObject json = new JSONObject(resposta.toString());

                // Verifica se o CEP é válido
                if (cep == null || cep.length() != 8 || !cep.matches("\\d{8}")) {
                    System.out.println("CEP inválido! Deve conter exatamente 8 números.");
                    return;  // Retorna se o CEP for inválido
                }

                // Cria um objeto Endereco e preenche com os dados da API
                Endereco endereco = new Endereco();
                endereco.setLogradouro(json.getString("logradouro"));
                endereco.setBairro(json.getString("bairro"));
                endereco.setLocalidade(json.getString("localidade"));
                endereco.setUf(json.getString("uf"));

                // Exibe os dados do endereço
                System.out.println("\nEndereço encontrado:");
                System.out.println("Rua: " + endereco.getLogradouro());
                System.out.println("Bairro: " + endereco.getBairro());
                System.out.println("Cidade: " + endereco.getLocalidade() + " - " + endereco.getUf());

            } catch (IOException e) {
                System.err.println("Erro ao conectar na API: " + e.getMessage());  // Exibe erro caso falhe a conexão
            } catch (JSONException e) {
                System.err.println("Erro ao processar a resposta da API: " + e.getMessage());  // Exibe erro caso falhe o processamento do JSON
            }

            // Pergunta ao usuário se as informações estão corretas
            System.out.print("\nAs informações estão corretas? (1 - Sim / 2 - Não): ");
            int confirmacao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer após o nextInt()

            if (confirmacao == 1) {
                System.out.println("Endereco confirmado!");
            } else {
                // Caso o usuário queira corrigir o endereço
                System.out.println("Por favor, digite o endereço manualmente.");
                System.out.print("Rua: ");
                String ruaManual = scanner.nextLine();
                System.out.print("Bairro: ");
                String bairroManual = scanner.nextLine();
                System.out.print("Cidade: ");
                String cidadeManual = scanner.nextLine();
                System.out.print("Estado (UF): ");
                String estadoManual = scanner.nextLine();
                System.out.println("Endereço atualizado! " + ruaManual + ", " + bairroManual + ", " + cidadeManual + " - " + estadoManual);
            }

            // Pergunta qual método de frete o usuário prefere
            System.out.println("Escolha o método de frete:");
            System.out.println("1 - Frete Padrão");
            System.out.println("2 - Frete Expresso");
            int opcaoFrete = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer após o nextInt()

            // Define o tipo de frete escolhido e o custo
            Frete frete;
            double custoSeguro = 0.0;

            if (opcaoFrete == 1) {
                frete = new FretePadrao(7);  // Define o frete padrão com prazo de 7 dias
            } else if (opcaoFrete == 2) {
                frete = new FreteExpresso(0.02, 5);  // Define o frete expresso com custo adicional de 2% e prazo de 5 dias
                System.out.println("Deseja contratar um seguro ao frete de 2% do valor do produto? (1 - Sim / 2 - Não)");
                int opcaoSeguro = scanner.nextInt();

                if (opcaoSeguro == 1 && frete instanceof SeguroFrete) {
                    frete = new FreteExpresso(0.02, 5);
                    SeguroFrete freteComSeguro = (SeguroFrete) frete;
                    custoSeguro = freteComSeguro.calcularSeguro(this.total);  // Calcula o custo do seguro
                }
            } else {
                System.out.println("Opção inválida. Usando frete padrão.");
                frete = new FretePadrao(7);  // Se a opção for inválida, usa o frete padrão
            }

            frete = new FreteExpresso(5);  // Substitui o frete para frete expresso com custo de 5 reais

            double custoFrete = frete.calcularFrete(this.total);  // Calcula o custo do frete
            custoFrete += custoSeguro;  // Adiciona o custo do seguro, se houver
            total += custoFrete;  // Atualiza o total

            // Atualiza o status do pedido e exibe as informações de frete
            statusPedido = StatusPedido.ENVIADO;
            System.out.println("Endereco confirmado! Seu pedido foi " + statusPedido.getDescricao() + " com sucesso!");
            System.out.printf("Custo do frete (com seguro se houver): R$ %.2f\n", custoFrete);
            System.out.println("O pedido será entregue em " + frete.getTempoDeEntrega() + " dias!");
            System.out.printf("Valor total do pedido: R$ %.2f\n", total);

            this.total = 0.0;  // Limpa o total após a confirmação do pedido
            sistemaUsuario();  // Retorna ao menu principal
        } else if (opcaoRecebimento == 2) {
            // Caso o usuário escolha retirar na loja
            statusPedido = StatusPedido.SEPARADO;
            System.out.println("Seu pedido foi " + statusPedido.getDescricao() + " com sucesso!");
            this.total = 0.0;  // Limpa o total após a confirmação do pedido
            sistemaUsuario();  // Retorna ao menu principal
        } else {
            // Caso a opção seja inválida
            System.out.println("Opção inválida!");
        }
    }
}