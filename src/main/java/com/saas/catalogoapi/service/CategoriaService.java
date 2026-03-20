package com.saas.catalogoapi.service;

import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.exception.CategoriaNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CategoriaService {
    private final List<CategoriaResponse> categoria = new ArrayList<>();

    private final AtomicLong contadorID = new AtomicLong(0);

    public CategoriaService() {
        categoria.add(new CategoriaResponse(
                contadorID.incrementAndGet(), "Roupas", "Verifique suas pecas de roupa favoritas",
                true, LocalDateTime.now()
        ));
        categoria.add(new CategoriaResponse(
                contadorID.incrementAndGet(), "Tecnologia", "Produtos mais atuais de tecnologia",
                true, LocalDateTime.now()
        ));
    }

    public List<CategoriaResponse> getCategoria() {
        return categoria;
    }

    public CategoriaResponse buscarporID(Long id) {
        return categoria.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public CategoriaResponse criarCategoia(CategoriaRequest request) {
        CategoriaResponse novaCategoria = new CategoriaResponse(
                contadorID.incrementAndGet(),
                request.nome(),
                request.descricao(),
                true,
                LocalDateTime.now()
        );
        categoria.add(novaCategoria);
        return novaCategoria;
    }
}

