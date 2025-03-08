package cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientedeAtacado extends Cliente {
    private double descontoEspecial;
    private long cnpj;
    public static ArrayList<ClientedeAtacado> catalogoClienteAtacado = new ArrayList<>();

    public double getDescontoEspecial() {
        return descontoEspecial;
    }

    public void setDescontoEspecial(double descontoEspecial) {
        this.descontoEspecial = descontoEspecial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public void cadastrarCliente(Scanner scanner){
            super.cadastrarCliente(scanner);
            scanner.nextLine(); // Limpa o buffer

            if (getIdade() < 18) {
                System.out.println("Erro! Idade não permitida. Retornando ao menu principal.");
                return;
            }

            System.out.print("Digite o seu CNPJ: ");
            this.cnpj = scanner.nextLong();

            System.out.print("Digite o desconto especial em porcentagem: ");
            this.descontoEspecial = scanner.nextDouble();
            System.out.println("Cadastro de Cliente Atacado concluído.");

        ClientedeAtacado novoClienteAtacado = new ClientedeAtacado();

        novoClienteAtacado.setNome(getNome());
        novoClienteAtacado.setIdade(getIdade());
        novoClienteAtacado.setCep(getCep());
        novoClienteAtacado.setSenha(getSenha());
        novoClienteAtacado.setCnpj(cnpj);
        novoClienteAtacado.setDescontoEspecial(descontoEspecial);
        catalogoClienteAtacado.add(novoClienteAtacado);

        }




    }
