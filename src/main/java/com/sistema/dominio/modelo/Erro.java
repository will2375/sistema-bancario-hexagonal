package com.sistema.dominio.modelo;

public class Erro {

    public static void obrigatorio(String nome) {
        throw new NegocioException(nome + " é obrigatorio");
    }

    public static void inexistente(String nome) {
        throw new NegocioException(nome + "é inexistente");
    }

    public static void saldoInsuficiente() {
        throw new NegocioException("saldo insuficiente");
    }

    public static void mesmaConta() {
        throw new NegocioException("conta debito e credito devem ser diferente");
    }
}
