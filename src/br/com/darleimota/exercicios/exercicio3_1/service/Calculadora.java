package br.com.darleimota.exercicios.exercicio3_1.service;

import br.com.darleimota.exercicios.exercicio3_1.exception.DivisaoPorZeroException;

public class Calculadora {

    public double dividir(double numero1, double numero2) {
        if (numero2 == 0) {
            throw new DivisaoPorZeroException();
        }
        return numero1 / numero2;
    }
}
