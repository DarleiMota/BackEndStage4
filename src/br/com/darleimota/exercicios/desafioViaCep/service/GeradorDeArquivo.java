package br.com.darleimota.exercicios.desafioViaCep.service;

import br.com.darleimota.exercicios.desafioViaCep.model.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void salvarJson(Endereco endereco) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(endereco);

        try (FileWriter escrita = new FileWriter("endereco.json")) {
            escrita.write(json);
            System.out.println("Arquivo endereco.json criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}

