package com.datasoft.prueba_tecnica.models.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String fullName;
    private String username;
    private String state;
}
