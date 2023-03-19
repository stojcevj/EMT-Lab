package com.example.emtlab.exceptions;

public class AuthorIdNotFoundException extends RuntimeException{
    public AuthorIdNotFoundException(Long authorId) {
        super("Author with ID:" + authorId + " is not found!");
    }
}
