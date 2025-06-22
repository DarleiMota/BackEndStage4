package br.com.darleimota.exercicios.exercicio3_1.exception;

public class DivisaoPorZeroException extends RuntimeException {

    public DivisaoPorZeroException() {
        super("Divisão por zero não é permitida.");
    }
}
