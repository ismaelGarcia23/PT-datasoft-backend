package com.datasoft.prueba_tecnica.models.dto.requets;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "El username es requerido")
    private String username;

    @NotBlank(message = "La contraseña es requerida")
    private String password;
}
