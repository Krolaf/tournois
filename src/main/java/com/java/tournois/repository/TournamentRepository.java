package com.java.tournois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.tournois.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
} 