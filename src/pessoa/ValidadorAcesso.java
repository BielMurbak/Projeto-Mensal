package pessoa;

import sistema.SistemaAdm;
import sistema.SistemaUsuario;

//Class ValidadorAcesso
//Atributos

public class ValidadorAcesso {
    private String nomeLogin;
    private int senhaLogin;

    // Getters e Setters para os atributos nomeLogin e senhaLogin
    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public int getSenhaLogin() {
        return senhaLogin;
    }

    public void setSenhaLogin(int senhaLogin) {
        this.senhaLogin = senhaLogin;
    }

   //Metodo de verificar login de Cliente atacado
    public void realizarLoginClienteAtacado(ClienteAtacado clienteAtacado) {
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

   //Metodo de verificar login Cliente Varejo
    public void realizarLoginCliente(ClienteVarejo clienteVarejo) {
        // Verifica se o nome do clienteVarejo é igual ao nome de login
        if (clienteVarejo.getNome().equals(nomeLogin)) {
            // Verifica se a senha está correta
            if(clienteVarejo.getSenha() == senhaLogin){
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

    //Metodo de verificar login de adm
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
