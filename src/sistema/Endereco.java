package sistema;

public class Endereco {

    // Atributos de endereço
    private String cep; // CEP do endereço
    private String logradouro; // Nome da rua ou avenida
    private String complemento; // Complemento do endereço (ex: número do apartamento)
    private String bairro; // Bairro onde o endereço se encontra
    private String localidade; // Cidade ou município
    private String uf; // Unidade Federativa (Estado)
    private String ddd; // Código de Discagem Direta à Distância (DDD) da região

    // Método getter para o CEP
    public String getCep() {
        return cep;
    }

    // Método setter para o CEP
    public void setCep(String cep) {
        this.cep = cep;
    }

    // Método getter para o logradouro (rua/avenida)
    public String getLogradouro() {
        return logradouro;
    }

    // Método setter para o logradouro (rua/avenida)
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    // Método getter para o complemento (ex: número do apartamento)
    public String getComplemento() {
        return complemento;
    }

    // Método setter para o complemento (ex: número do apartamento)
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    // Método getter para o bairro
    public String getBairro() {
        return bairro;
    }

    // Método setter para o bairro
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    // Método getter para a localidade (cidade ou município)
    public String getLocalidade() {
        return localidade;
    }

    // Método setter para a localidade (cidade ou município)
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    // Método getter para a Unidade Federativa (UF)
    public String getUf() {
        return uf;
    }

    // Método setter para a Unidade Federativa (UF)
    public void setUf(String uf) {
        this.uf = uf;
    }

    // Método getter para o DDD
    public String getDdd() {
        return ddd;
    }

    // Método setter para o DDD
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
}
