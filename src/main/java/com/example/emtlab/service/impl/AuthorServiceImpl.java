package com.example.emtlab.service.impl;

import com.example.emtlab.exceptions.CountryIdNotFoundException;
import com.example.emtlab.model.Author;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.dto.AuthorDto;
import com.example.emtlab.repository.AuthorRepository;
import com.example.emtlab.repository.CountryRepository;
import com.example.emtlab.service.AuthorService;
import com.example.emtlab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> saveAuthor(AuthorDto authorDto) {
        Country country = countryRepository.findById(authorDto.getCountryId())
                .orElseThrow(() -> new CountryIdNotFoundException(authorDto.getCountryId()));

        return Optional.of(authorRepository.save(new Author(authorDto.getName(), authorDto.getSurname(), country)));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
