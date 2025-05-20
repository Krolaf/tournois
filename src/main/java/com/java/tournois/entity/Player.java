package com.java.tournois.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private Integer eloRating;
    @OneToOne
    private User user;
    // Map<Game, PlayerStats> statistics à gérer plus tard

    public Player() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public Integer getEloRating() { return eloRating; }
    public void setEloRating(Integer eloRating) { this.eloRating = eloRating; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
} 