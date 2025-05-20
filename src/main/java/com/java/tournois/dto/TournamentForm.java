package com.java.tournois.dto;

import java.time.LocalDateTime;

import com.java.tournois.entity.MatchFormat;

public class TournamentForm {
    private String tournamentType;
    private String name;
    private String description;
    private Long game;
    private Long gameMode;
    private Integer maxParticipants;
    private MatchFormat matchFormat;
    private String rewards;
    private LocalDateTime registrationStartDate;
    private LocalDateTime registrationEndDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    // Champs spécifiques
    private Boolean hasThirdPlaceMatch;
    private Boolean hasConsolationFinal;
    private Integer numberOfRounds;
    private Boolean homeAndAway;

    // Getters et setters
    public String getTournamentType() { return tournamentType; }
    public void setTournamentType(String tournamentType) { this.tournamentType = tournamentType; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getGame() { return game; }
    public void setGame(Long game) { this.game = game; }
    public Long getGameMode() { return gameMode; }
    public void setGameMode(Long gameMode) { this.gameMode = gameMode; }
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
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }
    public Boolean getHasThirdPlaceMatch() { return hasThirdPlaceMatch; }
    public void setHasThirdPlaceMatch(Boolean hasThirdPlaceMatch) { this.hasThirdPlaceMatch = hasThirdPlaceMatch; }
    public Boolean getHasConsolationFinal() { return hasConsolationFinal; }
    public void setHasConsolationFinal(Boolean hasConsolationFinal) { this.hasConsolationFinal = hasConsolationFinal; }
    public Integer getNumberOfRounds() { return numberOfRounds; }
    public void setNumberOfRounds(Integer numberOfRounds) { this.numberOfRounds = numberOfRounds; }
    public Boolean getHomeAndAway() { return homeAndAway; }
    public void setHomeAndAway(Boolean homeAndAway) { this.homeAndAway = homeAndAway; }
} 