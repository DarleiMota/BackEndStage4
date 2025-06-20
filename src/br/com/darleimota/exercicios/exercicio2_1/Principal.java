/*
1 - Crie uma classe Pessoa usando o conceito de Record em Java, com atributos
como nome, idade e cidade. Em seguida, implemente um programa que utiliza a biblioteca
Gson para converter um JSON representando uma pessoa em um objeto do tipo Pessoa.
*/
package br.com.darleimota.exercicios.exercicio2_1;

import com.google.gson.Gson;

public class Principal {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Criando o Json através da biblioteca Gson.
        Pessoa pessoa = new Pessoa("Darlei", 39, "Brasília");
        String jsonPessoa = gson.toJson(pessoa);
        System.out.println("Apresentando aqui a criação de Json do tipo pessoa");
        System.out.println(jsonPessoa);

        // Convertendo em um objeto
        Pessoa pessoaClass = gson.fromJson(jsonPessoa, Pessoa.class);
        System.out.println("Apresentando aqui a conversão do Json em um objeto");
        System.out.println(pessoaClass);
    }
}
