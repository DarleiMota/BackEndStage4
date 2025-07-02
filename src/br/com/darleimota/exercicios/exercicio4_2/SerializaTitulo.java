/*
2 -Defina uma classe chamada Titulo com os atributos necessários. Em seguida,
crie um programa que instancia um objeto Titulo, serializa esse objeto para JSON usando a
biblioteca Gson e imprime o resultado.

3 -Modifique o programa anterior para que o JSON gerado seja formatado de maneira mais
elegante. Utilize o método setPrettyPrinting para alcançar esse resultado.

*/

package br.com.darleimota.exercicios.exercicio4_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializaTitulo {
    public static void main(String[] args) {
        Titulo titulo = new Titulo("Senhor dos Anéis", 2001);
        Gson gson = new Gson();

        // exercício 2
        System.out.println("Exercício 2");
        String json = gson.toJson(titulo);
        System.out.println(json);

        System.out.println(" ");

        // exercício 3
        System.out.println("Exercício 3");
        Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
        String jsonFormatado = gson1.toJson(titulo);
        System.out.println(jsonFormatado);


    }
}
