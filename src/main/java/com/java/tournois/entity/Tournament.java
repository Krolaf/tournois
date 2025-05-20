package com.java.tournois.entity;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournaments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tournament_type")
public abstract class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    // Pour simplifier, on ne gère que le nom du jeu ici
    private String gameName;
    private Integer maxParticipants;
    @Enumerated(EnumType.STRING)
    private MatchFormat matchFormat;
    private String rewards;
    private LocalDateTime registrationStartDate;
    private LocalDateTime registrationEndDate;
    @ManyToOne
    private Game game;
    @ManyToOne
    private GameMode gameMode;

    public Tournament() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    public String getGameName() { return gameName; }
    public void setGameName(String gameName) { this.gameName = gameName; }
    public Integer getMaxParticipants() { return maxParticipants; }
    public void setMaxParticipants(Integer maxParticipants) { this.maxParticipants = maxParticipants; }
    public MatchFormat getMatchFormat() { return matchFormat; }
    public void setMatchFormat(MatchFormat matchFormat) { this.matchFormat = matchFormat; }
    public String getRewards() { return rewards; }
    public void setRewards(String rewards) { this.rewards = rewards; }
    public LocalDateTime getRegistrationStartDate() { return registrationStartDate; }
    public void setRegistrationStartDate(LocalDateTime registrationStartDate) { this.registrationStartDate = registrationStartDate; }
    public LocalDateTime getRegistrationEndDate() { return registrationEndDate; }
    public void setRegistrationEndDate(LocalDateTime registrationEndDate) { this.registrationEndDate = registrationEndDate; }
    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }
    public GameMode getGameMode() { return gameMode; }
    public void setGameMode(GameMode gameMode) { this.gameMode = gameMode; }
} 