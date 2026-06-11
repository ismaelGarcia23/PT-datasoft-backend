package com.datasoft.prueba_tecnica.utils.mappers;

import com.datasoft.prueba_tecnica.models.dto.requets.RegisterRequest;
import com.datasoft.prueba_tecnica.models.dto.response.UserResponse;
import com.datasoft.prueba_tecnica.models.entities.UserEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    UserResponse toResponse(UserEntity entity);
    UserEntity toEntity(RegisterRequest request);
}
