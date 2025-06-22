package br.com.darleimota.exercicios.exercicio3_2.exception;

public class SenhaInvalidaException extends RuntimeException{

    public SenhaInvalidaException(String mensagem){
        super(mensagem);
    }
}
