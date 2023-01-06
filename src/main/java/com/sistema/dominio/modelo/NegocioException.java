package com.sistema.dominio.modelo;

public class NegocioException extends RuntimeException {

    public NegocioException(String mensagem) {

        super(mensagem);
    }
}
