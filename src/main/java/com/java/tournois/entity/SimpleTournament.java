package com.java.tournois.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SIMPLE")
public class SimpleTournament extends Tournament {
    // Pas de champs supplémentaires pour le CRUD de base
} 