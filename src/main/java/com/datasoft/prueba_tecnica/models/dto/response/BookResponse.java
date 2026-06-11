package com.datasoft.prueba_tecnica.models.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookResponse {
    private Long id;
    private String name;
    private String summary;
    private BigDecimal price;
    private String image;
    private GenereResponse genere;
}
