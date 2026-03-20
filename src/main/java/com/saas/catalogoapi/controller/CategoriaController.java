package com.saas.catalogoapi.controller;

import com.saas.catalogoapi.dto.CategoriaRequest;
import com.saas.catalogoapi.dto.CategoriaResponse;
import com.saas.catalogoapi.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@Tag(name = "Categorias", description = "Endpoints para criar categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController (CategoriaService categoriaService) { this.categoriaService = categoriaService; }

    @GetMapping
    @Operation(summary = "Listar todas as categorias", description = "Retorna a lista completa de categorias do sistema")
    public ResponseEntity<List<CategoriaResponse>> listarTodos() {
        return ResponseEntity.ok(categoriaService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria por id", description = "Retorna umaa categoria pelo identificador")
    public ResponseEntity<CategoriaResponse> buscarporID(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarporID(id));
    }

    @PostMapping
    @Operation(summary = "Criar nova categoria", description = "Criando uma nova categoria")
    public ResponseEntity<CategoriaResponse> criar(@RequestBody CategoriaRequest request) {
        CategoriaResponse criado = categoriaService.criarCategoia(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }
}