package br.com.darleimota.exercicios.desafioViaCep.api;

import br.com.darleimota.exercicios.desafioViaCep.model.Endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(json, Endereco.class);

            if (endereco.getCep() == null) {
                return null; // API retornou erro
            }

            return endereco;

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao consultar API: " + e.getMessage());
            return null;
        }
    }
}