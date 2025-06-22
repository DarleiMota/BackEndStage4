/*
Crie um programa que lê uma senha do usuário. Utilize o bloco try/catch para capturar a
exceção SenhaInvalidaException, uma classe de exceção personalizada que deve ser lançada caso
a senha não atenda a critérios específicos (por exemplo, ter pelo menos 8 caracteres).

 Ler a senha do usuário
 Fazer bloco try/catch
 Capturar a exceção SenhaInvalidaException,
 Classe personalizada para testar a senha de 8 caracteres
 */

package br.com.darleimota.exercicios.exercicio3_2.app;

import br.com.darleimota.exercicios.exercicio3_2.exception.SenhaInvalidaException;
import br.com.darleimota.exercicios.exercicio3_2.util.ValidadorDeSenha;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ValidadorDeSenha validador = new ValidadorDeSenha();

        String senha = "";
        boolean opcao = false;

        while (!opcao) {

            try {
                System.out.println("Registre sua senha de acesso");
                senha = scanner.nextLine();
                validador.validarSenha(senha);

                opcao = true;
            }catch (SenhaInvalidaException e){
                System.out.println("Erro " + e.getMessage());
            }
            finally {
                System.out.println("Tentativa de validação concluída.");
            }
        }
        System.out.println("Programa encerrado!! ");
    }
}