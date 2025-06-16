package br.com.darleimota.exercicios.exercicio1_3.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TradutorMyMemory {

    private static final String URL_API = "https://api.mymemory.translated.net/get";

    public String traduzirParaIngles(String textoPortugues) throws IOException, InterruptedException {
        String textoCodificado = URLEncoder.encode(textoPortugues, StandardCharsets.UTF_8);

        String urlCompleta = URL_API + "?q=" + textoCodificado + "&langpair=pt%7Cen";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlCompleta))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro na tradução: status " + response.statusCode());
        }

        return tratarResposta(response.body());
    }

    private String tratarResposta(String jsonResponse) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
        JsonObject responseData = jsonObject.getAsJsonObject("responseData");
        return responseData.get("translatedText").getAsString();
    }
}