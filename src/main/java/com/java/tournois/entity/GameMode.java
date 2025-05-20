package com.java.tournois.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GameMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer scoreToWin;

    public GameMode() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getMinPlayers() { return minPlayers; }
    public void setMinPlayers(Integer minPlayers) { this.minPlayers = minPlayers; }
    public Integer getMaxPlayers() { return maxPlayers; }
    public void setMaxPlayers(Integer maxPlayers) { this.maxPlayers = maxPlayers; }
    public Integer getScoreToWin() { return scoreToWin; }
    public void setScoreToWin(Integer scoreToWin) { this.scoreToWin = scoreToWin; }
} 