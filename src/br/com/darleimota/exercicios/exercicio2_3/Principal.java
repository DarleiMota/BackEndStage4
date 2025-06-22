/*
Crie uma classe Livro que contenha atributos como título, autor e um objeto
representando a editora. Em seguida, implemente um programa que utiliza a biblioteca
Gson para converter um JSON aninhado representando um livro em um objeto do tipo Livro.
 */

package br.com.darleimota.exercicios.exercicio2_3;

import br.com.darleimota.exercicios.exercicio2_3.model.Livro;
import com.google.gson.Gson;

public class Principal {
    public static void main(String[] args) {

        Gson gson = new Gson();

        // Fazendo um json contendo todos os dados, um objeto dentro de outro objeto

        String jsonLivro = """
                      {
                    "titulo": "O nome do vento",
                    "autor": "Patrick Rothfuss",
                    "editora": {
                        "nome": "Arqueiro",
                        "cidade": "São Paulo"
                    }
                }
                """;

        System.out.println("=======Modelo de conversão=====");
        System.out.println("Modelo do json do Livro que vamos converter");
        System.out.println(jsonLivro);

        // Convertendo em objeto junto com outro objeto dentro
        Livro livroNomeDoVento = gson.fromJson(jsonLivro, Livro.class);

        System.out.println("\nMoledo convertido em class");
        System.out.println(livroNomeDoVento);
        System.out.println("===============================");

        // Convertendo novamente em um Json
        String jsonLivroConvertido = gson.toJson(livroNomeDoVento);

        System.out.println("\nVoltando para modelo de Json");
        System.out.println(jsonLivroConvertido);
        System.out.println("===================================");
    }
}
