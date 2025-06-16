package br.com.darleimota.exercicios.exercicio1_3.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConsultarTheMealDB {

    public void buscarReceita(String nomeReceita) {
        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s="
                + URLEncoder.encode(nomeReceita, StandardCharsets.UTF_8);

        try {
            String json = fazerRequisicao(url);
            tratarResposta(json);
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na requisição: " + e.getMessage());
        }
    }

    private String fazerRequisicao(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private void tratarResposta(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        JsonElement mealsElement = jsonObject.get("meals");

        if (mealsElement == null || mealsElement.isJsonNull()) {
            System.out.println("Receita não encontrada");
            return;
        }

        JsonArray meals = mealsElement.getAsJsonArray();

        for (int i = 0; i < meals.size(); i++) {
            JsonObject meal = meals.get(i).getAsJsonObject();

            String nome = meal.get("strMeal").getAsString();
            String categoria = meal.get("strCategory").getAsString();
            String area = meal.get("strArea").getAsString();
            String instrucoes = meal.get("strInstructions").getAsString();
            String imagem = meal.get("strMealThumb").getAsString();

            System.out.println("\n Receita Encontrada:");
            System.out.println("---------------------------");
            System.out.println("- Nome: " + nome);
            System.out.println("- Categoria: " + categoria);
            System.out.println("- Área: " + area);
            System.out.println("- Instruções: " + instrucoes);
            System.out.println("- Imagem: " + imagem);
            System.out.println("---------------------------\n");

        }
    }
}
