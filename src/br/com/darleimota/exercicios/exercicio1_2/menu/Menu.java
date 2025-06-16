package br.com.darleimota.exercicios.exercicio1_2.menu;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String escolherCripto() {

        System.out.println("\nQual é a criptomoeda desejada?");
        System.out.println("1 - Bitcoin (BTC)");
        System.out.println("2 - Ethereum (ETH)");
        System.out.println("3 - Tether (USDT)");
        System.out.println("4 - Binance Coin (BNB)");
        System.out.println("5 - Solana (SOL)");
        System.out.println("6 - XRP (XRP)");
        System.out.println("7 - USD Coin (USDC)");
        System.out.println("8 - Dogecoin (DOGE)");
        System.out.println("9 - Cardano (ADA)");
        System.out.println("10 - Avalanche (AVAX)");
        System.out.print("Escolha uma opção: ");

        int opcaoCripto = scanner.nextInt();
        scanner.nextLine();

        String criptoMoeda;

        switch (opcaoCripto) {
            case 1 -> criptoMoeda = "bitcoin";
            case 2 -> criptoMoeda = "ethereum";
            case 3 -> criptoMoeda = "tether";
            case 4 -> criptoMoeda = "binancecoin";
            case 5 -> criptoMoeda = "solana";
            case 6 -> criptoMoeda = "ripple";
            case 7 -> criptoMoeda = "usd-coin";
            case 8 -> criptoMoeda = "dogecoin";
            case 9 -> criptoMoeda = "cardano";
            case 10 -> criptoMoeda = "avalanche-2";
            default -> {
                System.out.println("Opção invalida. Será considerado Bitcoin.");
                criptoMoeda = "bitcoin";
            }
        }
        return criptoMoeda;
    }

    public String escolherMoeda(){
        System.out.println("\nEm qual moeda deseja a cotação?");
        System.out.println("1 - Real (BRL)");
        System.out.println("2 - Dólar (USD)");
        System.out.println("3 - Euro (EUR)");
        System.out.print("Escolha uma opção: ");

        int opcaoMoeda = scanner.nextInt();
        scanner.nextLine();

        String moeda;

        switch (opcaoMoeda) {
            case 1 -> moeda = "brl";
            case 2 -> moeda = "usd";
            case 3 -> moeda = "eur";
            default -> {
                System.out.println("Opção invalida. Será considerado Real (BRL)");
                moeda = "brl";
            }
        }
        return moeda;
    }
}
