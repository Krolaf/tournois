package com.java.tournois.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ROUND_ROBIN")
public class RoundRobinTournament extends Tournament {
    private Integer numberOfRounds;
    private Boolean homeAndAway;

    public RoundRobinTournament() {}

    public Integer getNumberOfRounds() { return numberOfRounds; }
    public void setNumberOfRounds(Integer numberOfRounds) { this.numberOfRounds = numberOfRounds; }
    public Boolean getHomeAndAway() { return homeAndAway; }
    public void setHomeAndAway(Boolean homeAndAway) { this.homeAndAway = homeAndAway; }
} 