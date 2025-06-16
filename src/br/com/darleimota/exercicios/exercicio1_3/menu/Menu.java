package br.com.darleimota.exercicios.exercicio1_3.menu;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void exibirApresentacao() {
        System.out.println("=========================================");
        System.out.println("----Bem-vindo ao Consultor de Receitas----");
        System.out.println("-----API TheMealDB - Powered by Java-----");
        System.out.println("=========================================");
    }

    public int exibirMenuPrincipal() {
        System.out.println("\nO que você deseja fazer?");
        System.out.println("1 - Buscar receita por nome");
        System.out.println("2 - Sair");
        System.out.print("Escolha uma opção: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, digite um número válido (1 ou 2): ");
            scanner.next();
        }

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public String solicitarNomeReceita(){
        System.out.print("\nDigite o nome da receita que deseja buscar: ");
        return scanner.nextLine().trim();
    }

    public void exibirMensagemSaida(){
        System.out.println("\nObrigado por utilizar nosso sistema!");
        System.out.println("Feito por Darlei Mota");
    }

    public void exibirOpcaoInvalida(){
        System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
    }
}
