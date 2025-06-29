package br.com.darleimota.exercicios.exercicio3_3.service;

import br.com.darleimota.exercicios.exercicio3_3.exception.ErroConsultaGiHubException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService {

    private Gson gson = new Gson();

    public UsuarioGitHub buscarUsuario(String nomeUsuario){
        String url = construirUrl(nomeUsuario);
        String json = fazerRequisicao(url);
        return converterJsonParaObjeto(json);
    }

    public String construirUrl(String nomeUsuario) {
        return "https://api.github.com/users/" + nomeUsuario;
    }

    public String fazerRequisicao(String url) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            int statusCode = response.statusCode();

            if(statusCode == 404){
                throw new ErroConsultaGiHubException("Usuario não encontrado. Verifique o nome digitado");
            } else if (statusCode >= 400){
                throw new ErroConsultaGiHubException("Erro na consulta: codigo " + statusCode);
            }

            return response.body();

        }catch (IOException | InterruptedException e){
            throw new RuntimeException("Erro da conexão da API do GitHub: ");
        }
    }

    private UsuarioGitHub converterJsonParaObjeto(String json){
        return gson.fromJson(json, UsuarioGitHub.class);
    }
}
