package com.java.tournois.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
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

    public Game() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public GameFormat getFormat() { return format; }
    public void setFormat(GameFormat format) { this.format = format; }
    public Integer getAverageMatchDuration() { return averageMatchDuration; }
    public void setAverageMatchDuration(Integer averageMatchDuration) { this.averageMatchDuration = averageMatchDuration; }
    public List<GameMode> getAvailableModes() { return availableModes; }
    public void setAvailableModes(List<GameMode> availableModes) { this.availableModes = availableModes; }
} 