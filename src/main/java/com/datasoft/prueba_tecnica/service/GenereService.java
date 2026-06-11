package com.datasoft.prueba_tecnica.service;

import com.datasoft.prueba_tecnica.models.dto.response.GenereResponse;
import com.datasoft.prueba_tecnica.models.entities.GenereEntity;
import com.datasoft.prueba_tecnica.repositories.GenereRepository;
import com.datasoft.prueba_tecnica.utils.exceptions.GenereNotFoundException;
import com.datasoft.prueba_tecnica.utils.mappers.GenereMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class GenereService {
    private final GenereRepository genereRepository;
    private final GenereMapper genereMapper;

    @Transactional(readOnly = true)
    public Page<GenereResponse> listAll(Pageable pageable){
        return genereRepository.findAll(pageable)
                .map(genereMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public GenereResponse findbyName(String name) {
        GenereEntity entity = genereRepository.findByName(name)
                .orElseThrow(() -> new GenereNotFoundException("No existe el género: " + name));

        return genereMapper.toResponse(entity);
    }
}
