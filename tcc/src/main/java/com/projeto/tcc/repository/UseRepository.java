package com.projeto.tcc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.tcc.domain.user.User;



public interface UseRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

}
