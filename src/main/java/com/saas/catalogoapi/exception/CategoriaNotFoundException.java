package com.saas.catalogoapi.exception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super("Categoria nao encontrada com o ID:" + id);
    }
}
