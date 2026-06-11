package com.datasoft.prueba_tecnica.models.dto.requets;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookRequest {

    @Size(max = 50, message = "El nombre no puede exceder 50 caracteres")
    private String name;

    @Size(max = 500, message = "El resumen no puede exceder 500 caracteres")
    private String summary;

    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Digits(integer = 4, fraction = 2, message = "El precio debe tener máximo 4 enteros y 2 decimales")
    private BigDecimal price;

    @Size(max = 500, message = "La URL de imagen no puede exceder 500 caracteres")
    private String image;

    @Positive(message = "El id del género debe ser positivo")
    private Long genreId;
}
