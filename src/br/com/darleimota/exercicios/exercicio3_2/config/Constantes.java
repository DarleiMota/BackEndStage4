package br.com.darleimota.exercicios.exercicio3_2.config;

import java.util.Set;

public class Constantes {

    public static final int TAMANHO_MINIMO_DE_ENTRADA = 8;
    public static final int MIN = 8;
    public static final int MAX = 64;
    //set.of usso de um array set para add senhas para bloquear.
    public static final Set<String> BLOCKLIST = Set.of(
            "ab345678", "password12", "qwerty", "ab11111111", "letmein", "admin"
    );
}
