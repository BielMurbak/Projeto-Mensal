package src.Cliente;

import src.SistemaUsuario;

public class Login {
    private String nomeLogin;
    private int  senhaLogin;

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

    //metodo
    public void realizarLoginClienteAtacado( ClientedeAtacado clienteAtacado) {

        if (clienteAtacado.getNome().equals(nomeLogin)) {
            if(clienteAtacado.getSenha()==(senhaLogin)){
                System.out.println("login realizado com sucesso!");
                SistemaUsuario sU = new SistemaUsuario();
                sU.sistemaUsuario();
            }else{
                System.out.println("Erro! Essa senha nao foi encotrada!");
            }
        }else{
            System.out.println("Erro! Esse nome nao foi encotrado!");
        }

    }//close the realizarLoginClienteAtacado


    public void realizarLoginCliente( Cliente cliente) {

        if (cliente.getNome().equals(nomeLogin)) {
            if(cliente.getSenha()==(senhaLogin)){
                System.out.println("login realizado com sucesso!");
            }else{
                System.out.println("Erro! Essa senha nao foi encotrada!");
            }
        }else{
            System.out.println("Erro! Esse nome nao foi encotrado!");
        }

    }//close the realizarLoginCliente


}//close the class
