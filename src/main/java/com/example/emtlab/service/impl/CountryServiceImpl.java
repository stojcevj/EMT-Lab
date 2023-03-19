package com.example.emtlab.service.impl;

import com.example.emtlab.model.Author;
import com.example.emtlab.model.Country;
import com.example.emtlab.model.dto.CountryDto;
import com.example.emtlab.repository.CountryRepository;
import com.example.emtlab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> saveCountry(CountryDto countryDto) {
        return Optional.of(countryRepository.save(new Country(countryDto.getName(), countryDto.getContinent())));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
