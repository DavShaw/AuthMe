package com.davshaw.authme.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davshaw.authme.roles.User;

public interface UserRepository  extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username); 

}
