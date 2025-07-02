/*
1 -Crie um programa em Java que escreva a seguinte mensagem em um arquivo chamado "arquivo.txt":
"Conteúdo a ser gravado no arquivo." Utilize as classes do pacote java.io.
*/

package br.com.darleimota.exercicios.exercicio4_1;

import java.io.FileWriter;
import java.io.IOException;

public class EscritaArquivo {
    public static void main(String[] args) {
        try (FileWriter escritor = new FileWriter("arquivo.txt")) {
            escritor.write("Gravação no arquivo confirmada.");
            System.out.println("Arquivo gravado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }
}
