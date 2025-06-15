package br.com.darleimota.exercicios.exercicio1_2;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu(scanner);
        ConsultaCoinGecko consulta = new ConsultaCoinGecko();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===============================");
            System.out.println(" Conversor de Criptomoedas ");
            System.out.println("===============================\n");

            String cripto = menu.escolherCripto();
            String moeda = menu.escolherMoeda();

            consulta.buscarCotacao(cripto, moeda);

            System.out.println("\nDeseja fazer outra consulta? (S/N)");
            String resposta = scanner.nextLine();

            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
                System.out.println("Programa finalizado. Até mais!");
            }
        }
    }
}

