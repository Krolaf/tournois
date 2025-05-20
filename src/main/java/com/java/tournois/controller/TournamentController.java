package com.java.tournois.controller;

import java.util.List;

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

import com.java.tournois.entity.DoubleEliminationTournament;
import com.java.tournois.entity.MatchFormat;
import com.java.tournois.entity.RoundRobinTournament;
import com.java.tournois.entity.SingleEliminationTournament;
import com.java.tournois.entity.Tournament;
import com.java.tournois.service.GameModeService;
import com.java.tournois.service.GameService;
import com.java.tournois.service.TournamentService;

@Controller
@RequestMapping("/tournament")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private GameService gameService;
    @Autowired
    private GameModeService gameModeService;

    @GetMapping("/list")
    public String listTournaments(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Tournament> tournamentPage = tournamentService.getAllTournaments(page, 5);
        model.addAttribute("tournamentPage", tournamentPage);
        return "tournament/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tournamentTypes", List.of("SINGLE_ELIMINATION", "DOUBLE_ELIMINATION", "ROUND_ROBIN"));
        model.addAttribute("matchFormats", MatchFormat.values());
        model.addAttribute("games", gameService.getAllGames(0, Integer.MAX_VALUE).getContent());
        model.addAttribute("gameModes", gameModeService.getAllGameModes());
        model.addAttribute("tournament", new SingleEliminationTournament());
        return "tournament/create";
    }

    @PostMapping("/create")
    public String createTournament(@RequestParam String tournamentType, @ModelAttribute Tournament tournament) {
        Tournament t;
        switch (tournamentType) {
            case "DOUBLE_ELIMINATION" -> t = new DoubleEliminationTournament();
            case "ROUND_ROBIN" -> t = new RoundRobinTournament();
            default -> t = new SingleEliminationTournament();
        }
        // Copier les propriétés communes
        t.setName(tournament.getName());
        t.setDescription(tournament.getDescription());
        t.setStartDate(tournament.getStartDate());
        t.setEndDate(tournament.getEndDate());
        t.setMaxParticipants(tournament.getMaxParticipants());
        t.setMatchFormat(tournament.getMatchFormat());
        t.setRewards(tournament.getRewards());
        t.setRegistrationStartDate(tournament.getRegistrationStartDate());
        t.setRegistrationEndDate(tournament.getRegistrationEndDate());
        t.setGame(tournament.getGame());
        t.setGameMode(tournament.getGameMode());
        // Champs spécifiques
        if (t instanceof SingleEliminationTournament s) {
            ((SingleEliminationTournament) t).setHasThirdPlaceMatch(((SingleEliminationTournament) tournament).getHasThirdPlaceMatch());
        } else if (t instanceof DoubleEliminationTournament d) {
            ((DoubleEliminationTournament) t).setHasConsolationFinal(((DoubleEliminationTournament) tournament).getHasConsolationFinal());
        } else if (t instanceof RoundRobinTournament r) {
            ((RoundRobinTournament) t).setNumberOfRounds(((RoundRobinTournament) tournament).getNumberOfRounds());
            ((RoundRobinTournament) t).setHomeAndAway(((RoundRobinTournament) tournament).getHomeAndAway());
        }
        tournamentService.saveTournament(t);
        return "redirect:/tournament/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentService.getTournamentById(id).orElseThrow();
        model.addAttribute("tournamentTypes", List.of("SINGLE_ELIMINATION", "DOUBLE_ELIMINATION", "ROUND_ROBIN"));
        model.addAttribute("matchFormats", MatchFormat.values());
        model.addAttribute("games", gameService.getAllGames(0, Integer.MAX_VALUE).getContent());
        model.addAttribute("gameModes", gameModeService.getAllGameModes());
        model.addAttribute("tournament", tournament);
        return "tournament/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTournament(@PathVariable Long id, @RequestParam String tournamentType, @ModelAttribute Tournament tournament) {
        tournament.setId(id);
        return createTournament(tournamentType, tournament);
    }

    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return "redirect:/tournament/list";
    }
} 