package br.com.darleimota.exercicios.desafioViaCep.model;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return logradouro + ", " + bairro + " - " + localidade + "/" + uf + " (CEP: " + cep + ")";
    }
}
