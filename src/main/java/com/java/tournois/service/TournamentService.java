package com.java.tournois.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.tournois.entity.Tournament;
import com.java.tournois.repository.TournamentRepository;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public Page<Tournament> getAllTournaments(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tournamentRepository.findAll(pageable);
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
} 