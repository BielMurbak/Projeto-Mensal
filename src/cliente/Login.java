package cliente;

import sistema.Administrador;
import sistema.SistemaAdm;
import sistema.SistemaUsuario;

public class Login {
    private String nomeLogin; // Nome de usuário para login
    private int senhaLogin; // Senha para login

    // Getters e Setters para os atributos nomeLogin e senhaLogin
    public String getNomeLogin() {
        return nomeLogin; // Retorna o nome de usuário
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin; // Define o nome de usuário
    }

    public int getSenhaLogin() {
        return senhaLogin; // Retorna a senha do usuário
    }

    public void setSenhaLogin(int senhaLogin) {
        this.senhaLogin = senhaLogin; // Define a senha do usuário
    }

    // Método para realizar login de um Cliente de Atacado
    public void realizarLoginClienteAtacado(ClientedeAtacado clienteAtacado) {
        // Verifica se o nome do cliente de atacado é igual ao nome de login
        if (clienteAtacado.getNome().equals(nomeLogin)) {
            // Verifica se a senha está correta
            if(clienteAtacado.getSenha() == senhaLogin){
                System.out.println("login realizado com sucesso!"); // Sucesso no login

                // Acessa o sistema de usuário
                SistemaUsuario sU = new SistemaUsuario();
                sU.sistemaUsuario();
            } else {
                System.out.println("Erro! Essa senha nao foi encotrada!"); // Senha incorreta
            }
        } else {
            System.out.println("Erro! Esse nome nao foi encotrado!"); // Nome não encontrado
        }
    }

    // Método para realizar login de um Cliente comum
    public void realizarLoginCliente(Cliente cliente) {
        // Verifica se o nome do cliente é igual ao nome de login
        if (cliente.getNome().equals(nomeLogin)) {
            // Verifica se a senha está correta
            if(cliente.getSenha() == senhaLogin){
                System.out.println("login realizado com sucesso!"); // Sucesso no login
                SistemaUsuario sU = new SistemaUsuario();
                sU.sistemaUsuario();
            } else {
                System.out.println("Erro! Essa senha nao foi encotrada!"); // Senha incorreta
            }
        } else {
            System.out.println("Erro! Esse nome nao foi encotrado!"); // Nome não encontrado
        }
    }

    /// Método para realizar login de um Administrador
    public void realizarloginAdm(Administrador adm) {
        // Cria um novo Administrador para verificar nome e senha
        Administrador admRealizarLogin = new Administrador();

        // Verifica se o nome do administrador corresponde ao nome de login
        if (nomeLogin.equals(admRealizarLogin.getNome())) {
            // Verifica se a senha corresponde
            if (senhaLogin == admRealizarLogin.getSenha()) {
                // Se correto, acessa o sistema de administrador
                SistemaAdm sA = new SistemaAdm();
                sA.sistemaAdm();
            } else {
                System.out.println("Erro! Senha nao existe no nosso banco de dados."); // Senha incorreta
            }
        } else {
            // Caso o nome não seja do administrador, verifica se é o nome padrão "adm"
            if (nomeLogin.equals("adm")) {
                // Verifica se a senha padrão "2425" está correta
                if (senhaLogin == 2425) {
                    SistemaAdm sA = new SistemaAdm();
                    sA.sistemaAdm();
                } else {
                    System.out.println("Erro! Senha nao existe no nosso banco de dados."); // Senha incorreta
                }
            } else {
                System.out.println("Erro! Nome e senha nao existe no nosso banco de dados."); // Nome não encontrado
            }
        }
    }
}
