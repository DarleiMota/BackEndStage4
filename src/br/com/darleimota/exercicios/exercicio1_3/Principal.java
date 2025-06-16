/*
Crie um programa Java que faça uma consulta à API do TheMealDB utilizando as
classes HttpClient, HttpRequest e HttpResponse. Solicite ao usuário que insira
o nome de uma receita e exiba as informações disponíveis sobre essa receita.
*/

package br.com.darleimota.exercicios.exercicio1_3;

import br.com.darleimota.exercicios.exercicio1_3.api.ConsultarTheMealDB;
import br.com.darleimota.exercicios.exercicio1_3.api.TradutorMyMemory;
import br.com.darleimota.exercicios.exercicio1_3.menu.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        ConsultarTheMealDB consulta = new ConsultarTheMealDB();
        TradutorMyMemory tradutor = new TradutorMyMemory();

        menu.exibirApresentacao();

        boolean continuar = true;

        while (continuar) {
            int opcao = menu.exibirMenuPrincipal();

            switch (opcao) {
                case 1 -> {
                    String nomeReceitaPt = menu.solicitarNomeReceita();

                    try {
                        // Tradução do nome da receita
                        String nomeReceitaEn = tradutor.traduzirParaIngles(nomeReceitaPt);
                        System.out.println("Buscando por: " + nomeReceitaEn);

                        // Consulta na API TheMealDB
                        consulta.buscarReceita(nomeReceitaEn);

                    } catch (IOException | InterruptedException e) {
                        System.out.println("Erro na tradução ou na consulta: " + e.getMessage());
                    }
                }
                case 2 -> {
                    menu.exibirMensagemSaida();
                    continuar = false;
                }
                default -> menu.exibirOpcaoInvalida();
            }
        }
        scanner.close();
    }
}