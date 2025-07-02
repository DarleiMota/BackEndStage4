package br.com.darleimota.exercicios.exercicio4_4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializaVeiculo {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", 2020);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(veiculo);

        System.out.println(json);
    }
}