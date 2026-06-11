package com.datasoft.prueba_tecnica.utils.mappers;

import com.datasoft.prueba_tecnica.models.dto.response.GenereResponse;
import com.datasoft.prueba_tecnica.models.entities.GenereEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface GenereMapper {
    GenereResponse toResponse(GenereEntity entity);
}
