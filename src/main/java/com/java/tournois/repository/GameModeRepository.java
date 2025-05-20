package com.java.tournois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.tournois.entity.GameMode;

public interface GameModeRepository extends JpaRepository<GameMode, Long> {
} 