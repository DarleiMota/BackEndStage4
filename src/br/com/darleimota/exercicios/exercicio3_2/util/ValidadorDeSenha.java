package br.com.darleimota.exercicios.exercicio3_2.util;

import br.com.darleimota.exercicios.exercicio3_2.config.Constantes;
import br.com.darleimota.exercicios.exercicio3_2.exception.SenhaInvalidaException;

public class ValidadorDeSenha {

    Constantes constantes = new Constantes();

    public void validarSenha(String s) {
        validarTamanho(s);
        validarMaiuscula(s);
        validarNumero(s);
        validarEspecial(s);
        validarBlocklist(s);
    }

    // Valida tamanho da senha, a partir de 8 até 64 evita NullPointerException
    private void validarTamanho(String s) {
        if (s == null || s.length() < Constantes.MIN || s.length() > Constantes.MAX)
            throw new SenhaInvalidaException("Senha precisa ter entre " + Constantes.MIN + " e " + Constantes.MAX + " caracteres.");
    }
    // Valida se tem pelo menos 1 letra maiuscula, s.char() -> a stream converte em código Unicode
    // para comparação, noneMatch vai retornar se o inteiro que representa um caracter da lista criada tem uma letra maiuscula
    // se não encontrar ele retorna Falso e cai na exceção.
    private void validarMaiuscula(String s) {
        if (s.chars().noneMatch(Character::isUpperCase))
            throw new SenhaInvalidaException("Inclua pelo menos uma letra maiúscula.");
    }

    // Ele repete a conversao e compara com isDigit (0 a 9) se existe número
    private void validarNumero(String s) {
        if (s.chars().noneMatch(Character::isDigit))
            throw new SenhaInvalidaException("Inclua pelo menos um número.");
    }

    // Ele repete a conversão e compara Usando indexOf(c) >= 0 para checar se o caractere
    // aparece na string com símbolos especiais.
    private void validarEspecial(String s) {
        if (s.chars().noneMatch(c -> "!@#$%^&*()_+-=[]{}|;:'\",.<>?/\\`~".indexOf(c)>=0))
            throw new SenhaInvalidaException("Adicione ao menos um caractere especial.");
    }

    //Converte s em letra minuscula e compara a lista Blocklist senhas que não podem ser usadas.
    private void validarBlocklist(String s) {
        if (Constantes.BLOCKLIST.contains(s.toLowerCase())) {
            throw new SenhaInvalidaException("Senha fraca ou vazada. Use outra.");
        }
    }
}
