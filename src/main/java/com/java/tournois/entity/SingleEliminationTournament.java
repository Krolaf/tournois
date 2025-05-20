package com.java.tournois.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SINGLE_ELIMINATION")
public class SingleEliminationTournament extends Tournament {
    private Boolean hasThirdPlaceMatch;

    public SingleEliminationTournament() {}

    public Boolean getHasThirdPlaceMatch() { return hasThirdPlaceMatch; }
    public void setHasThirdPlaceMatch(Boolean hasThirdPlaceMatch) { this.hasThirdPlaceMatch = hasThirdPlaceMatch; }
} 