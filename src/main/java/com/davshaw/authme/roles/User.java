package com.davshaw.authme.roles;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user")
public class User implements UserDetails{
    @Id
    @GeneratedValue
    @Column(name="id", unique = true, nullable = false)
    Integer id;

    @Column(name="user", unique = true, nullable = false)
    String user;

    @Column(name="password", unique = false, nullable = false)
    String password;

    @Column(name="email", unique = true, nullable = false)
    String email;

    @Column(name="firstname", unique = false, nullable = false)
    String firstname;

    @Column(name="lastname", unique = false, nullable = false)
    String lastname;

    @Column(name="country", unique = false, nullable = false)
    String country;

    @Column(name="role", unique = false, nullable = false)
    Roles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.user;
    }
}

