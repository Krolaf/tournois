package com.java.tournois.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.tournois.entity.GameMode;
import com.java.tournois.repository.GameModeRepository;

@Service
public class GameModeService {
    @Autowired
    private GameModeRepository gameModeRepository;

    public List<GameMode> getAllGameModes() {
        return gameModeRepository.findAll();
    }
} 