package br.com.darleimota.exercicios.exercicio1_2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConsultaCoinGecko {

    public void buscarCotacao(String cripto, String moeda) {

        String url = "https://api.coingecko.com/api/v3/simple/price?ids="
                + URLEncoder.encode(cripto, StandardCharsets.UTF_8)
                + "&vs_currencies=" + moeda;

        try {
            // Criando o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Criando o request GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Enviando o request e recebendo a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Tratando o JSON com GSON
            String json = response.body();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonObject criptoObject = jsonObject.getAsJsonObject(cripto);

            if (criptoObject != null && criptoObject.has(moeda)) {
                double valor = criptoObject.get(moeda).getAsDouble();

                System.out.printf("Cotação da %s em %s: %.2f%n",
                        cripto.substring(0, 1).toUpperCase() + cripto.substring(1),
                        moeda.toUpperCase(),
                        valor);
            } else {
                System.out.println("Não foi possível obter a cotação. Verifique se a moeda ou a cripto estão corretas.");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na requisição: " + e.getMessage());
        }
    }
}