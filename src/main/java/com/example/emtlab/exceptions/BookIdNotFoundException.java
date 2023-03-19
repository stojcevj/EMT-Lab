package com.example.emtlab.exceptions;

public class BookIdNotFoundException extends RuntimeException{
    public BookIdNotFoundException(Long bookID) {
        super("Book with ID:" + bookID + " is not found!");
    }
}
