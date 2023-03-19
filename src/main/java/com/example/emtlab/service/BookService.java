package com.example.emtlab.service;

import com.example.emtlab.model.Book;
import com.example.emtlab.model.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();

    Page<Book> listAllWithPagination(Pageable pageable);

    Optional<Book> findById(Long id);

    Optional<Book> saveBook(BookDto bookDto);

    Optional<Book> editBook(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);
}
