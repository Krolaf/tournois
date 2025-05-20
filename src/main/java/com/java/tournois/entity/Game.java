package com.java.tournois.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private GameFormat format;
    private Integer averageMatchDuration;
    @ManyToMany
    private List<GameMode> availableModes;
    // Getters, setters, constructeurs
} 