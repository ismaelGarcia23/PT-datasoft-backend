package com.datasoft.prueba_tecnica.repositories;

import com.datasoft.prueba_tecnica.models.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Page<BookEntity> findByGenere_Id(Long genreId, Pageable pageable);
    Page<BookEntity> findAll(Pageable pageable);
}
