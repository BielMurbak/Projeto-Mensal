package src;

import src.Cliente.Cliente;
import src.Cliente.ClientedeAtacado;
import src.Cliente.Login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = new Cliente();
        ClientedeAtacado clienteAtacado = new ClientedeAtacado();
        Login login = new Login();

        int aux = 0;
        String auxB;

        do {
            System.out.println("---Sistema e-commerce---");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Encerrar programa");
            System.out.println("Escolha uma opção:");
            aux = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer after nextInt()

            switch (aux) {
                case 1:

                    break;
                case 2:
                    System.out.println("Cliente Atacado?");
                    auxB = scanner.nextLine();
                    if(auxB.equalsIgnoreCase("Sim")){
                        clienteAtacado.cadastrarCliente(scanner);
                        ///clienteAtacado cadastrado.
                        scanner.nextLine();  // Clear the buffer after nextInt()
                        System.out.println("Digite seu nome de login: ");
                        String nomeLoginAtacado = scanner.nextLine();
                        System.out.println("Digite sua senha de login: ");
                        int senhaLoginAtacado = scanner.nextInt();
                        login.setNomeLogin(nomeLoginAtacado);
                        login.setSenhaLogin(senhaLoginAtacado);
                        login.realizarLogin(clienteAtacado);
                    }
                    cliente.cadastrarCliente(scanner);
                    ///cliente cadastrado.
                    break;
                case 3:
                    System.out.println("Programa Encerrado com sucesso.");
                    System.exit(0);
                default:
                    System.out.println("Erro! Numero digitado é invalido");
            }//close the switch

        }while(aux != 1 && aux !=2); //close the do

    }//close the function main

}//close the main