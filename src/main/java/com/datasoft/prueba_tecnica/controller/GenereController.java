package com.datasoft.prueba_tecnica.controller;

import com.datasoft.prueba_tecnica.models.dto.response.GenereResponse;
import com.datasoft.prueba_tecnica.service.GenereService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generes")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Géneros", description = "Consulta de géneros literarios")
public class GenereController {
    private final GenereService genereService;

    @GetMapping
    @Operation(summary = "Listar géneros", description = "Retorna todos los géneros paginados")
    public ResponseEntity<Page<GenereResponse>> listAll(Pageable pageable) {
        return ResponseEntity.ok(genereService.listAll(pageable));
    }

    @GetMapping("/name")
    @Operation(summary = "Buscar género por nombre", description = "Retorna el género que coincida con el nombre exacto")
    public ResponseEntity<GenereResponse> findByName(
            @Parameter(description = "Nombre del género a buscar") @RequestParam String name) {
        return ResponseEntity.ok(genereService.findbyName(name));
    }
}
