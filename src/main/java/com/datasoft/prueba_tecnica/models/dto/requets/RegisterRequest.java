package com.datasoft.prueba_tecnica.models.dto.requets;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "El nombre completo es requerido")
    @Size(max = 30, message = "El nombre completo no puede exceder 30 caracteres")
    private String fullName;

    @NotBlank(message = "El username es requerido")
    @Size(max = 20, message = "El username no puede exceder 20 caracteres")
    private String username;

    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;
}
