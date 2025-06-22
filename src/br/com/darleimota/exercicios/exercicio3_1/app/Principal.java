/*
Crie um programa simples que solicita dois números ao usuário e realiza a divisão do primeiro pelo
segundo. Utilize o bloco try/catch para tratar a exceção que pode ocorrer caso o usuário informe
0 como divisor.

Obs: A solução do exercicio foi feita na tentativa de fazer o mais completo possível
- Tratamento de erros
- Separação das responsabilidades
 */


package br.com.darleimota.exercicios.exercicio3_1.app;

import br.com.darleimota.exercicios.exercicio3_1.exception.DivisaoPorZeroException;
import br.com.darleimota.exercicios.exercicio3_1.exception.EntradaInvalidaException;
import br.com.darleimota.exercicios.exercicio3_1.service.Calculadora;
import br.com.darleimota.exercicios.exercicio3_1.util.ValidadorDeEntrada;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ValidadorDeEntrada validador = new ValidadorDeEntrada(scanner);
        final Calculadora calculadora = new Calculadora();

        System.out.println("=== Calculadora de Divisão ====");

        boolean sucesso = false;

        while (!sucesso){
            try{
                final double numero1 = validador.lerNumero("Digite o primeiro numero");
                final double numero2 = validador.lerNumero("Digite o segundo numero");
                final double resultado = calculadora.dividir(numero1,numero2);
                System.out.printf("O resultado da divisão é: %.4f%n", resultado);

                sucesso = true;
            }catch (DivisaoPorZeroException | EntradaInvalidaException e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println("Operação realizada com sucesso!!!");
            }
        }
        System.out.println("Programa encerrado com sucesso!!!");
        scanner.close();
    }
}
