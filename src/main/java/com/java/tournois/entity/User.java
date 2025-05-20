package com.java.tournois.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime registrationDate;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    // Getters, setters, constructeurs
} 