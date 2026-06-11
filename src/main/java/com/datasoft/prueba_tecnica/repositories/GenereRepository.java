package com.datasoft.prueba_tecnica.repositories;

import com.datasoft.prueba_tecnica.models.entities.GenereEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenereRepository extends JpaRepository<GenereEntity, Long> {
    Page<GenereEntity> findAll(Pageable pageable);
    Optional<GenereEntity> findByName(String name);
}
