package com.datasoft.prueba_tecnica.service;

import com.datasoft.prueba_tecnica.models.dto.requets.BookRequest;
import com.datasoft.prueba_tecnica.models.dto.requets.CreateBookRequest;
import com.datasoft.prueba_tecnica.models.dto.response.BookResponse;
import com.datasoft.prueba_tecnica.models.entities.BookEntity;
import com.datasoft.prueba_tecnica.models.entities.GenereEntity;
import com.datasoft.prueba_tecnica.models.entities.UserEntity;
import com.datasoft.prueba_tecnica.repositories.BookRepository;
import com.datasoft.prueba_tecnica.repositories.GenereRepository;
import com.datasoft.prueba_tecnica.repositories.UserRepository;
import com.datasoft.prueba_tecnica.utils.exceptions.BookNotFoundException;
import com.datasoft.prueba_tecnica.utils.exceptions.GenereNotFoundException;
import com.datasoft.prueba_tecnica.utils.exceptions.UserNotFoundException;
import com.datasoft.prueba_tecnica.utils.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final GenereRepository genereRepository;
    private final UserRepository userRepository;
    private final BookMapper bookMapper;

    @Transactional(readOnly = true)
    public Page<BookResponse> findAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Page<BookResponse> listByGenre(Long genreId, Pageable pageable) {
        if (!genereRepository.existsById(genreId)) {
            throw new GenereNotFoundException("No existe el género con id: " + genreId);
        }
        return bookRepository.findByGenere_Id(genreId, pageable)
                .map(bookMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public BookResponse findById(Long id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toResponse(book);
    }

    @Transactional
    public BookResponse update(Long id, BookRequest request) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        bookMapper.updateEntity(book, request);

        if (request.getGenreId() != null) {
            GenereEntity genere = genereRepository.findById(request.getGenreId())
                    .orElseThrow(() -> new GenereNotFoundException("No existe el género con id: " + request.getGenreId()));
            book.setGenere(genere);
        }

        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Transactional
    public BookResponse create(CreateBookRequest request) {
        GenereEntity genere = genereRepository.findById(request.getGenreId())
                .orElseThrow(() -> new GenereNotFoundException("No existe el género con id: " + request.getGenreId()));

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado: " + username));

        BookEntity book = bookMapper.toEntity(request);
        book.setGenere(genere);
        book.setUser(user);

        return bookMapper.toResponse(bookRepository.save(book));
    }
}
