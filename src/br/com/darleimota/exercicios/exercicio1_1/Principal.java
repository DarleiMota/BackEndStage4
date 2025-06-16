/*
Crie um programa em Java que utilize as classes HttpClient, HttpRequest e HttpResponse para
fazer uma consulta à API do Google Books. Solicite ao usuário que insira o título de um livro,
e exiba as informações disponíveis sobre o livro retornado pela API.
*/

package br.com.darleimota.exercicios.exercicio1_1;

import br.com.darleimota.exercicios.exercicio1_1.modelo.Item;
import br.com.darleimota.exercicios.exercicio1_1.modelo.ResultadoLivro;
import br.com.darleimota.exercicios.exercicio1_1.modelo.VolumeInfo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String apiKey = "AIzaSyCCdxzpwQOZycUzctdJ7zkpEYTNGU9nj_4";

        //1 - ENTRADA DE DADOS
        System.out.println("Digite o nome do Livro: ");
        String titulo = entrada.nextLine();

        //2 - GERANDO A URL NO FORMATO PADRAO HTTP
        String url = "https://www.googleapis.com/books/v1/volumes?q="
                + URLEncoder.encode("intitle:"+ titulo, StandardCharsets.UTF_8)
                + "&key=" + apiKey;

        //Fazendo um try catch para tratamento de erro
        try {
            // 3- CRIAÇÃO DO CLIENTE HTTP, responsável pela requisição get
            HttpClient client = HttpClient.newHttpClient();

            // 4 - CRIAÇÃO DO REQUEST, cria um pedido GET com a url gerada.
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // 5 - ENVIO DO REQUEST E RECEBIMENTO DA RESPOSTA
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 6 - GSON configurando Json recebido e
            Gson gson = new Gson();
            ResultadoLivro resultado = gson.fromJson(response.body(), ResultadoLivro.class);

            // 7 - Mostra o resultado do Gson que a classe ResultadoLivro pediu, items.
            List<Item> items = resultado.getItems();

            // 8 - Tratamento se não encontrar a pesquisa
            if (items == null) {
                System.out.println("Nenhum livro encontrado.");
                return;
            }

            for (Item item : items) {
                VolumeInfo info = item.getVolumeInfo();
                System.out.println("-------------------------------");
                System.out.println("Título: " + info.getTitle());
                System.out.println("Autores: " + info.getAuthors());
                System.out.println("Descrição: " + info.getDescription());
                System.out.println("Preview: " + info.getPreviewLink());
                System.out.println("-------------------------------\n");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na requisição: " + e.getMessage());
        }
    }
}