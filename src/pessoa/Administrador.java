package pessoa;

import java.util.ArrayList;
import java.util.Scanner;

//Class adm
//atributos
public class Administrador extends Pessoa{
    protected int idAdm;

    public ArrayList<Administrador> listaAdm = new ArrayList<>();  // Lista de administradores cadastrados

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    //metodo de cadastar Adm
    public void adicionarAdm(Scanner scanner) {

        super.cadastrarCliente(scanner);

        System.out.print("Digite o id: ");
        this.idAdm = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Cadastro do Administrador realizado com sucesso");

        // Cria um novo objeto de Administrador e preenche os dados fornecidos
        Administrador novoAdm = new Administrador();
        novoAdm.setNome(getNome());
        novoAdm.setIdade(getIdade());
        novoAdm.setCep(getCep());
        novoAdm.setCpf(getCpf());
        novoAdm.setSenha(getSenha());
        novoAdm.setIdAdm(getIdAdm());

        // Adiciona o novo administrador à lista de administradores
        listaAdm.add(novoAdm);
    }
}
