/*
2 - Modifique o programa do Exercício anterior para permitir a conversão de um JSON mesmo
 se alguns campos estiverem ausentes ou se houver campos adicionais não representados no
  objeto Pessoa. Consulte a documentação da biblioteca Gson para flexibilizar a
  conversão.
*/
package br.com.darleimota.exercicios.exercicio2_2;

import br.com.darleimota.exercicios.exercicio2_1.Pessoa;
import com.google.gson.Gson;
public class Principal {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Modelo 1 - JSON criado pelo Gson
        Pessoa pessoa1 = new Pessoa("Julia", 14, "Minas Gerais");
        String jsonPessoa1 = gson.toJson(pessoa1);
        System.out.println("\n===== Modelo 1 - JSON Completo =====");
        System.out.println("JSON:");
        System.out.println(jsonPessoa1);
        Pessoa pessoaClass1 = gson.fromJson(jsonPessoa1, Pessoa.class);
        System.out.println("Objeto Pessoa:");
        System.out.println(pessoaClass1);
        System.out.println("===================================\n");

        // Modelo 2 - JSON com atributo faltando
        String jsonPessoa2 = """
                {
                    "nome": "Hernandes",
                    "idade": 62
                }
                """;
        System.out.println("===== Modelo 2 - JSON com atributo faltando =====");
        System.out.println("JSON:");
        System.out.println(jsonPessoa2);
        Pessoa pessoaClass2 = gson.fromJson(jsonPessoa2, Pessoa.class);
        System.out.println("Objeto Pessoa:");
        System.out.println(pessoaClass2);
        System.out.println("=================================================\n");

        // Modelo 3 - JSON com atributo a mais
        String jsonPessoa3 = """
                {
                    "nome":"Mariana",
                    "idade": 36,
                    "cidade":"Brasilia",
                    "profissao":"Gerente de projeto"
                }
                """;
        System.out.println("===== Modelo 3 - JSON com atributo a mais =====");
        System.out.println("JSON:");
        System.out.println(jsonPessoa3);
        Pessoa pessoaClass3 = gson.fromJson(jsonPessoa3, Pessoa.class);
        System.out.println("Objeto Pessoa:");
        System.out.println(pessoaClass3);
        System.out.println("==============================================\n");
    }
}
