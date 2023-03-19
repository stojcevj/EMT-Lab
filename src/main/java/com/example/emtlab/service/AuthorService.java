package com.example.emtlab.service;

import com.example.emtlab.model.Author;
import com.example.emtlab.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAll();

    Optional<Author> findById(Long id);

    Optional<Author> saveAuthor(AuthorDto authorDto);

    void deleteById(Long id);
}
