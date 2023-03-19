package com.example.emtlab.config;

import com.example.emtlab.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomEmailAndPasswordAuthenticator implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public CustomEmailAndPasswordAuthenticator(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        if(email.isEmpty() || password.isEmpty()){
            return null;
        }

        UserDetails userDetails = userService.loadUserByUsername(email);

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            return null;
        }

        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return  aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
