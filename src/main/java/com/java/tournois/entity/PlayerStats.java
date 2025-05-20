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

    public PlayerStats() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getWins() { return wins; }
    public void setWins(Integer wins) { this.wins = wins; }
    public Integer getLosses() { return losses; }
    public void setLosses(Integer losses) { this.losses = losses; }
    public Integer getDraws() { return draws; }
    public void setDraws(Integer draws) { this.draws = draws; }
    public Double getWinRate() { return winRate; }
    public void setWinRate(Double winRate) { this.winRate = winRate; }
    public Integer getEloRating() { return eloRating; }
    public void setEloRating(Integer eloRating) { this.eloRating = eloRating; }
} 