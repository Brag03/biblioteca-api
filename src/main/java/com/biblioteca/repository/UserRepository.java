package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.User;
public interface UserRepository extends JpaRepository<User, Long> { }