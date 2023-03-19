package com.example.emtlab.service;

import com.example.emtlab.model.Country;
import com.example.emtlab.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> listAll();

    Optional<Country> findById(Long id);

    Optional<Country> saveCountry(CountryDto countryDto);

    void deleteById(Long id);
}
