package com.java.tournois.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer wins;
    private Integer losses;
    private Integer draws;
    private Double winRate;
    private Integer eloRating;
    // Getters, setters, constructeurs
} 