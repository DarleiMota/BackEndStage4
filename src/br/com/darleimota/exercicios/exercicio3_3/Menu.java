package br.com.darleimota.exercicios.exercicio3_3;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final GitHubService gitHubService = new GitHubService();

    public void exibirMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("====================================");
            System.out.println("*******| CONSULTA GITHUB API |*******");
            System.out.println("====================================");
            System.out.println("1 - Consultar usuário do GitHub");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> consultarUsuario();

                case "2" -> {
                    continuar = false;
                    System.out.println("Encerrando o programa, até mais!!!");
                }
                default -> System.out.println("Opção invalida. Tente novamente.");
            }
        }
    }

    private void consultarUsuario() {
        System.out.println("Digite o nome de usuário do Github: ");
        String nomeUsuario = scanner.nextLine();

        try {
            UsuarioGitHub usuario = gitHubService.buscarUsuario(nomeUsuario);
            System.out.println(usuario);
        } catch (ErroConsultaGiHubException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao consultar usuário " + e.getMessage());
        }

    }
}