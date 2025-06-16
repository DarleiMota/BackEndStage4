package br.com.darleimota.exercicios.exercicio1_2.api;

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
        String url = gerarUrl(cripto, moeda);

        try {
            String json = fazerRequisicao(url);
            double valor = extrairValorDoJson(json, cripto, moeda);

            System.out.printf("\n💰 Cotação da %s em %s: %.2f%n",
                    formatarNome(cripto),
                    moeda.toUpperCase(),
                    valor);

        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Erro na requisição: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("❌ Não foi possível obter a cotação. Verifique se a moeda ou a cripto estão corretas.");
        }
    }

    private String gerarUrl(String cripto, String moeda) {
        return "https://api.coingecko.com/api/v3/simple/price?ids="
                + URLEncoder.encode(cripto, StandardCharsets.UTF_8)
                + "&vs_currencies=" + moeda;
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

    private double extrairValorDoJson(String json, String cripto, String moeda) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject criptoObject = jsonObject.getAsJsonObject(cripto);
        return criptoObject.get(moeda).getAsDouble();
    }

    private String formatarNome(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}