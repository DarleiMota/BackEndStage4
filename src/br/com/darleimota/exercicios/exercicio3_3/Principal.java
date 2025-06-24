/*
Desenvolva um programa em Java que permite aos usuários consultar informações sobre um usuário do
GitHub (utilize a API pública do GitHub para obter os dados). Crie uma classe de exceção personalizada,
ErroConsultaGitHubException, que estende RuntimeException. Lance essa exceção quando o nome de usuário
não for encontrado. No bloco catch, trate de forma específica essa exceção, exibindo uma
mensagem amigável.

- Consular infomações no de usuario GITHUB
consultar por nome.
- Usar API GITHUB obter dados
- Classe de exceção personalizada
ErroConsultaGitHubException
Quando não achar o usuário na busca
Exibir uma mensagem amigavel
- Registro de consultar em um arquivo
- Separar tudo por responsabilidades.
*/

package br.com.darleimota.exercicios.exercicio3_3;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}
