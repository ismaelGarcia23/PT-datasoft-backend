package com.datasoft.prueba_tecnica.utils.mappers;

import com.datasoft.prueba_tecnica.models.dto.requets.BookRequest;
import com.datasoft.prueba_tecnica.models.dto.requets.CreateBookRequest;
import com.datasoft.prueba_tecnica.models.dto.response.BookResponse;
import com.datasoft.prueba_tecnica.models.entities.BookEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {GenereMapper.class, UserMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface BookMapper {
    BookResponse toResponse(BookEntity entity);

    @Mapping(target = "genere", ignore = true)
    @Mapping(target = "user", ignore = true)
    BookEntity toEntity(CreateBookRequest request);

    @Mapping(target = "genere", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateEntity(@MappingTarget BookEntity entity, BookRequest request);
}
