package com.vendaseuvoto.usuarios.exceptions;

public class UsuarioJaExisteException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public UsuarioJaExisteException(String mensagem) {
        super(mensagem);

    }
}