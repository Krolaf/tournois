package com.java.tournois.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.tournois.entity.SimpleTournament;
import com.java.tournois.entity.Tournament;
import com.java.tournois.service.TournamentService;

@Controller
@RequestMapping("/tournament")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/list")
    public String listTournaments(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Tournament> tournamentPage = tournamentService.getAllTournaments(page, 5);
        model.addAttribute("tournamentPage", tournamentPage);
        return "tournament/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tournament", new SimpleTournament());
        return "tournament/create";
    }

    @PostMapping("/create")
    public String createTournament(@ModelAttribute SimpleTournament tournament) {
        tournamentService.saveTournament(tournament);
        return "redirect:/tournament/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentService.getTournamentById(id).orElseThrow();
        model.addAttribute("tournament", tournament);
        return "tournament/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTournament(@PathVariable Long id, @ModelAttribute SimpleTournament tournament) {
        tournament.setId(id);
        tournamentService.saveTournament(tournament);
        return "redirect:/tournament/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return "redirect:/tournament/list";
    }
} 