package com.java.tournois.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DOUBLE_ELIMINATION")
public class DoubleEliminationTournament extends Tournament {
    private Boolean hasConsolationFinal;

    public DoubleEliminationTournament() {}

    public Boolean getHasConsolationFinal() { return hasConsolationFinal; }
    public void setHasConsolationFinal(Boolean hasConsolationFinal) { this.hasConsolationFinal = hasConsolationFinal; }
} 