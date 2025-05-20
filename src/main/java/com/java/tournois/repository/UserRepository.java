package com.java.tournois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.tournois.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
} 