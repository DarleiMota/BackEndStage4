package br.com.darleimota.exercicios.desafioViaCep.app;

import br.com.darleimota.exercicios.desafioViaCep.api.ConsultaCep;
import br.com.darleimota.exercicios.desafioViaCep.model.Endereco;
import br.com.darleimota.exercicios.desafioViaCep.service.GeradorDeArquivo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();
        GeradorDeArquivo gerador = new GeradorDeArquivo();

        while (true) {
            System.out.println("\n📦 Buscador de CEP");
            System.out.println("1 - Buscar CEP");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o CEP (somente números): ");
                    String cep = scanner.nextLine();

                    Endereco endereco = consulta.buscaEndereco(cep);
                    if (endereco != null) {
                        System.out.println("\nEndereço encontrado:");
                        System.out.println(endereco);
                        gerador.salvarJson(endereco);
                    } else {
                        System.out.println("❌ CEP inválido ou não encontrado.");
                    }
                    break;

                case "0":
                    System.out.println("Encerrando...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
