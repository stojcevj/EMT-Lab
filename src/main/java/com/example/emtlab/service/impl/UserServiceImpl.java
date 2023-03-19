package com.example.emtlab.service.impl;

import com.example.emtlab.exceptions.UserIdNotFoundException;
import com.example.emtlab.exceptions.UserUserEmailNotFoundException;
import com.example.emtlab.model.User;
import com.example.emtlab.model.enumerations.UserAuthorities;
import com.example.emtlab.repository.UserRepository;
import com.example.emtlab.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(String Name, String Email, String Password, UserAuthorities Authorities) {
        if(!Name.isEmpty() && !Email.isEmpty() && !Password.isEmpty()){
            return userRepository.save(new User(Name, Email, passwordEncoder.encode(Password), Authorities));
        }
        throw new IllegalArgumentException();
    }

    @Override
    public User deleteUser(Long userID) {
        User tmp = userRepository.findById(userID).orElseThrow(() -> new UserIdNotFoundException(userID));
        userRepository.delete(tmp);
        return tmp;
    }

    @Override
    public User updateUser(Long userID, String Name, String Email, String Password, UserAuthorities Authorities) {
        User tmp = userRepository.findById(userID).orElseThrow(() -> new UserIdNotFoundException(userID));

        tmp.setUserName(Name);
        tmp.setUserEmail(Email);
        tmp.setUserPassword(Password);
        tmp.setUserAuthorities(Authorities);

        return userRepository.save(tmp);
    }

    @Override
    public User loadById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserIdNotFoundException(id));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUserEmail(s).orElseThrow(() -> new UserUserEmailNotFoundException(s));
    }
}
