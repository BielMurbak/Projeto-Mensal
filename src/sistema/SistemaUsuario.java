package sistema;

import org.json.JSONException;
import org.json.JSONObject;
import pagamento.*;
import produtos.Tenis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static produtos.Tenis.*;

public class SistemaUsuario {
    public void sistemaUsuario() {

        Scanner scanner = new Scanner(System.in);
        Tenis tenis = new Tenis(null, 0, 0, 0);
        List<Tenis> carrinho = new ArrayList<>();

        Pagamento pagamentoCredito = new pagamento.CartaoDeCredito();
        Pagamento pagamentoDebito = new pagamento.CartaoDebito();
        Pagamento pagamentoPix = new pagamento.Pix();
        Pagamento pagamentoDinheiro = new pagamento.Dinheiro();

        sistema.Endereco Endereco = new Endereco();


        int auxI = 0;
        double total = 0;
        int continuarCadastro = 0;

        catalogo.add(new Tenis("Nike Air Max", 1, 10, 499.99));
        catalogo.add(new Tenis("Adidas Ultra Boost", 2, 5, 599.99));
        catalogo.add(new Tenis("Puma RS-X", 3, 8, 349.99));

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
                    do {
                        exibirCatalogo();
                        System.out.println("Digite codigo do produto:");
                        int codigoProduto = scanner.nextInt();
                        System.out.println("Digite a quantidade:");
                        int quantidadeProduto = scanner.nextInt();
                        tenis.condicionaisDeCompra(codigoProduto, quantidadeProduto, total);
                        for (Tenis t : catalogo) {
                            if (t.getCodigo() == codigoProduto) {
                                // Criar um novo objeto Tenis apenas com a quantidade comprada
                                Tenis compra = new Tenis(t.getNome(), t.getCodigo(), quantidadeProduto, t.getPreco());
                                carrinho.add(compra);
                            }
                        }
                        System.out.println("Deseja comprar outro tênis? 1 - Sim / 2 - Não");
                        continuarCadastro = scanner.nextInt();
                    } while (continuarCadastro == 1);
                    for (Tenis item : carrinho) {
                        System.out.println("Produto: " + item.getNome() + " | Código: " + item.getCodigo() + " | Quantidade: " + item.getQuantidade() + " | Preço Unitário: R$ " + item.getPreco());
                    }
                    System.out.println("Total:" + total);
                    System.out.println("---- Pagamento ----");
                    System.out.println("1-Cartao de credito");
                    System.out.println("2-Cartao de debito");
                    System.out.println("3-Pix");
                    System.out.println("4-Dinheiro");
                    System.out.print("Digite sua opcao:");
                    int opcaoPagamento = scanner.nextInt();
                    if (opcaoPagamento == 1) {
                        apiCep(scanner);
                        pagamentoCredito.realizarPagamento(total);
                    } else if (opcaoPagamento == 2) {
                        apiCep(scanner);
                        pagamentoDebito.realizarPagamento(total);
                    } else if (opcaoPagamento == 3) {
                        apiCep(scanner);
                        pagamentoPix.realizarPagamento(total);
                    } else if (opcaoPagamento == 4) {
                        pagamentoDinheiro.realizarPagamento(total);
                        apiCep(scanner);

                    } else {
                        System.out.println("Erro! Número digitado é inválido.");
                    }
                    break;
                case 2:
                    for (Tenis item : carrinho) {
                        System.out.println("Produto: " + item.getNome() + " | Código: " + item.getCodigo() + " | Quantidade: " + item.getQuantidade() + " | Preço Unitário: R$ " + item.getPreco());
                    }
                    System.out.println("Total:" + total);
                    System.out.println("---- Pagamento ----");
                    System.out.println("1-Cartao de credito");
                    System.out.println("2-Cartao de debito");
                    System.out.println("3-Pix");
                    System.out.println("4-Dinheiro");
                    System.out.print("Digite sua opcao:");
                    int opPagamento = scanner.nextInt();
                    if (opPagamento == 1) {
                        pagamentoCredito.realizarPagamento(total);
                        apiCep(scanner);
                    } else if (opPagamento == 2) {
                        pagamentoDebito.realizarPagamento(total);
                        apiCep(scanner);
                    } else if (opPagamento == 3) {
                        pagamentoPix.realizarPagamento(total);
                    } else if (opPagamento == 4) {
                        pagamentoDinheiro.realizarPagamento(total);
                        apiCep(scanner);
                    } else {
                        System.out.println("Erro! Número digitado é inválido.");
                    }
                    break;
                case 3:
                    apiCep(scanner);
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
                    //
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
        } while (escolhaSuporte < 1 || escolhaSuporte > 4);
    }
    private void apiCep(Scanner scanner ){
        System.out.println("---- Escolha a opção de recebimento ----");
        System.out.println("1 - Entrega");
        System.out.println("2 - Retirada na loja");
        System.out.println("3 - Sair");
        System.out.print("Digite sua opção: ");
        int opcaoRecebimento = scanner.nextInt();

        if (opcaoRecebimento == 1) {
            System.out.println("Informe o cep:");
            scanner.nextLine(); // Consumir a quebra de linha
            String cep = scanner.nextLine();

            try {
                // Faz a requisição para a API ViaCEP
                String url = "https://viacep.com.br/ws/" + cep + "/json/";
                HttpURLConnection conexao = (HttpURLConnection) new URL(url).openConnection();
                conexao.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                StringBuilder resposta = new StringBuilder();
                String linha;

                while ((linha = reader.readLine()) != null) {
                    resposta.append(linha);
                }
                reader.close();

                // Converte a resposta para um objeto JSON
                JSONObject json = new JSONObject(resposta.toString());

                // Verifica se o CEP é válido
                if (json.has("erro")) {
                    System.out.println("CEP inválido! Tente novamente.");
                    return;
                }

                // Criando um objeto Endereco e preenchendo com os dados da API
                Endereco endereco = new Endereco();
                endereco.setLogradouro(json.getString("logradouro"));
                endereco.setBairro(json.getString("bairro"));
                endereco.setLocalidade(json.getString("localidade"));
                endereco.setUf(json.getString("uf"));

                // Exibir os dados do endereço
                System.out.println("\nEndereço encontrado:");
                System.out.println("Rua: " + endereco.getLogradouro());
                System.out.println("Bairro: " + endereco.getBairro());
                System.out.println("Cidade: " + endereco.getLocalidade() + " - " + endereco.getUf());

            } catch (IOException e) {
                System.err.println("Erro ao conectar na API: " + e.getMessage());
            } catch (JSONException e) {
                System.err.println("Erro ao processar a resposta da API: " + e.getMessage());
            }

            System.out.print("\nAs informações estão corretas? (1 - Sim / 2 - Não): ");
            int confirmacao = scanner.nextInt();

            if (confirmacao == 1) {
                System.out.println("Endereço confirmado! O pedido será entregue.");
            } else {
                System.out.println("Por favor, digite o endereço manualmente.");
                scanner.nextLine(); // Consumir a quebra de linha
                System.out.print("Rua: ");
                String ruaManual = scanner.nextLine();
                System.out.print("Bairro: ");
                String bairroManual = scanner.nextLine();
                System.out.print("Cidade: ");
                String cidadeManual = scanner.nextLine();
                System.out.print("Estado (UF): ");
                String estadoManual = scanner.nextLine();

                System.out.println("Endereço atualizado! O pedido será entregue em: " + ruaManual + ", " + bairroManual + ", " + cidadeManual + " - " + estadoManual);
                SistemaUsuario sU = new SistemaUsuario();
                sU.sistemaUsuario();
            }

        }else if (opcaoRecebimento == 2) {
            System.out.println("Seu pedido estará disponível para retirada na loja.");
        } else {
            System.out.println("Opção inválida!");
        }
    }
}
