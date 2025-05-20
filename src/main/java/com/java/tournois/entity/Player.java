package com.java.tournois.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private Integer eloRating;
    @OneToOne
    private User user;
    // Map<Game, PlayerStats> statistics à gérer plus tard
    // Getters, setters, constructeurs
} 