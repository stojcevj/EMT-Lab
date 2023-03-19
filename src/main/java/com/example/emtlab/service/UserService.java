package com.example.emtlab.service;

import com.example.emtlab.model.User;
import com.example.emtlab.model.enumerations.UserAuthorities;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> listAll();

    User createUser(String Name,
                    String Email,
                    String Password,
                    UserAuthorities Authorities);

    User deleteUser(Long userID);

    User updateUser(Long userID,
                    String Name,
                    String Email,
                    String Password,
                    UserAuthorities Authorities);

    User loadById(Long id);
}