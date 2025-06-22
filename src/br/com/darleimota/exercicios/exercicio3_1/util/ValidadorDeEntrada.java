package br.com.darleimota.exercicios.exercicio3_1.util;

import br.com.darleimota.exercicios.exercicio3_1.config.Constantes;
import br.com.darleimota.exercicios.exercicio3_1.exception.EntradaInvalidaException;

import java.util.Scanner;

public class ValidadorDeEntrada {

    private final Scanner scanner;

    public ValidadorDeEntrada(Scanner scanner) {
        this.scanner = scanner;
    }

    public double lerNumero(String mensagem) {
        System.out.println(mensagem);
        String entrada = scanner.nextLine().trim();

        if (entrada.length() > Constantes.TAMANHO_MAXIMO_ENTRADA) {
            throw new EntradaInvalidaException("Entrada muito longa. Máximo de "
                    + Constantes.TAMANHO_MAXIMO_ENTRADA + "caracteres.");
        }

        entrada = entrada.replace(",", ".");
        try {
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException("Formato invalido. Digite um numero válido (Ex.: 10,5 ou 10.5");
        }
    }
}
