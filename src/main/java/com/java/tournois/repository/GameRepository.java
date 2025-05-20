package com.java.tournois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.tournois.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
} 