package com.example.emtlab.exceptions;

public class UserUserEmailNotFoundException extends RuntimeException{
    public UserUserEmailNotFoundException(String email) {
        super("User with email:" + email + " is not found!");
    }
}
