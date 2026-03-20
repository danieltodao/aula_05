package com.saas.catalogoapi.dto;

import java.time.LocalDateTime;

public record CategoriaResponse(
        Long id,
        String nome,
        String descricao,
        LocalDateTime criadoEm
) {
}
