package com.example.emtlab.model;

import com.example.emtlab.model.enumerations.UserAuthorities;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "userLogin")
public class User implements UserDetails {

    public User(String Name, String Email, String Password, UserAuthorities Authorities) {
        this.userName = Name;
        this.userEmail = Email;
        this.userPassword = Password;
        this.userAuthorities = Authorities;
    }

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long Id;

    private String userName;

    private String userEmail;

    private String userPassword;

    @Enumerated(value = EnumType.STRING)
    private UserAuthorities userAuthorities;

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getUserAuthorities());
    }

    @Override
    public String getPassword() {
        return getUserPassword();
    }

    @Override
    public String getUsername() {
        return getUserEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
