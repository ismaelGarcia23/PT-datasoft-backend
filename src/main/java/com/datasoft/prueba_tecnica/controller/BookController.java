package com.datasoft.prueba_tecnica.controller;

import com.datasoft.prueba_tecnica.models.dto.requets.BookRequest;
import com.datasoft.prueba_tecnica.models.dto.requets.CreateBookRequest;
import com.datasoft.prueba_tecnica.models.dto.response.BookResponse;
import com.datasoft.prueba_tecnica.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Libros", description = "Gestión de libros")
public class BookController {
    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Listar todos los libros", description = "Retorna toda la lista de libros")
    public ResponseEntity<Page<BookResponse>> listAll(@ParameterObject Pageable pageable) {
        Page<BookResponse> responses = bookService.findAllBooks(pageable);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/genre/{genreId}")
    @Operation(summary = "Listar libros por género", description = "Retorna los libros paginados filtrados por género")
    public ResponseEntity<Page<BookResponse>> listByGenre(
            @Parameter(description = "ID del género") @PathVariable Long genreId,
            @ParameterObject Pageable pageable) {
        return ResponseEntity.ok(bookService.listByGenre(genreId, pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalle de un libro", description = "Retorna la información completa de un libro por su ID")
    public ResponseEntity<BookResponse> findById(
            @Parameter(description = "ID del libro") @PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar libro", description = "Actualiza los campos enviados del libro, los campos nulos se ignoran")
    public ResponseEntity<BookResponse> update(
            @Parameter(description = "ID del libro") @PathVariable Long id,
            @Valid @RequestBody BookRequest request) {
        return ResponseEntity.ok(bookService.update(id, request));
    }

    @PostMapping
    @Operation(summary = "Crear libro", description = "Crea un nuevo libro asociado al usuario autenticado")
    public ResponseEntity<BookResponse> create(@Valid @RequestBody CreateBookRequest request) {
        return ResponseEntity.status(201).body(bookService.create(request));
    }
}
