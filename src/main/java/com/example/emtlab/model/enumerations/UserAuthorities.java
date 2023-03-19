package com.example.emtlab.model.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthorities implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR,
    LIBRARIAN;

    @Override
    public String getAuthority() {
        return name();
    }
}
