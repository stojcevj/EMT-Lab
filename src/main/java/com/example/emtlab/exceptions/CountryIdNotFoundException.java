package com.example.emtlab.exceptions;

public class CountryIdNotFoundException extends RuntimeException{
    public CountryIdNotFoundException(Long countryId) {
        super("Country with ID:" + countryId + " is not found!");
    }
}
