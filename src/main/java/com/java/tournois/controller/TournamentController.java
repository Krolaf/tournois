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

import com.java.tournois.dto.TournamentForm;
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
        model.addAttribute("tournamentForm", new TournamentForm());
        return "tournament/create";
    }

    @PostMapping("/create")
    public String createTournament(@ModelAttribute TournamentForm form) {
        Tournament t;
        switch (form.getTournamentType()) {
            case "DOUBLE_ELIMINATION" -> {
                DoubleEliminationTournament d = new DoubleEliminationTournament();
                d.setHasConsolationFinal(form.getHasConsolationFinal());
                t = d;
            }
            case "ROUND_ROBIN" -> {
                RoundRobinTournament r = new RoundRobinTournament();
                r.setNumberOfRounds(form.getNumberOfRounds());
                r.setHomeAndAway(form.getHomeAndAway());
                t = r;
            }
            default -> {
                SingleEliminationTournament s = new SingleEliminationTournament();
                s.setHasThirdPlaceMatch(form.getHasThirdPlaceMatch());
                t = s;
            }
        }
        t.setName(form.getName());
        t.setDescription(form.getDescription());
        t.setStartDate(form.getStartDate());
        t.setEndDate(form.getEndDate());
        t.setMaxParticipants(form.getMaxParticipants());
        t.setMatchFormat(form.getMatchFormat());
        t.setRewards(form.getRewards());
        t.setRegistrationStartDate(form.getRegistrationStartDate());
        t.setRegistrationEndDate(form.getRegistrationEndDate());
        t.setGame(gameService.getGameById(form.getGame()).orElse(null));
        t.setGameMode(gameModeService.getAllGameModes().stream().filter(m -> m.getId().equals(form.getGameMode())).findFirst().orElse(null));
        tournamentService.saveTournament(t);
        return "redirect:/tournament/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentService.getTournamentById(id).orElseThrow();
        TournamentForm form = new TournamentForm();
        if (tournament instanceof SingleEliminationTournament s) {
            form.setTournamentType("SINGLE_ELIMINATION");
            form.setHasThirdPlaceMatch(s.getHasThirdPlaceMatch());
        } else if (tournament instanceof DoubleEliminationTournament d) {
            form.setTournamentType("DOUBLE_ELIMINATION");
            form.setHasConsolationFinal(d.getHasConsolationFinal());
        } else if (tournament instanceof RoundRobinTournament r) {
            form.setTournamentType("ROUND_ROBIN");
            form.setNumberOfRounds(r.getNumberOfRounds());
            form.setHomeAndAway(r.getHomeAndAway());
        }
        form.setName(tournament.getName());
        form.setDescription(tournament.getDescription());
        form.setStartDate(tournament.getStartDate());
        form.setEndDate(tournament.getEndDate());
        form.setMaxParticipants(tournament.getMaxParticipants());
        form.setMatchFormat(tournament.getMatchFormat());
        form.setRewards(tournament.getRewards());
        form.setRegistrationStartDate(tournament.getRegistrationStartDate());
        form.setRegistrationEndDate(tournament.getRegistrationEndDate());
        form.setGame(tournament.getGame() != null ? tournament.getGame().getId() : null);
        form.setGameMode(tournament.getGameMode() != null ? tournament.getGameMode().getId() : null);
        model.addAttribute("tournamentTypes", List.of("SINGLE_ELIMINATION", "DOUBLE_ELIMINATION", "ROUND_ROBIN"));
        model.addAttribute("matchFormats", MatchFormat.values());
        model.addAttribute("games", gameService.getAllGames(0, Integer.MAX_VALUE).getContent());
        model.addAttribute("gameModes", gameModeService.getAllGameModes());
        model.addAttribute("tournamentForm", form);
        model.addAttribute("tournamentId", id);
        return "tournament/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTournament(@PathVariable Long id, @ModelAttribute TournamentForm form) {
        Tournament t = tournamentService.getTournamentById(id).orElseThrow();
        if (t instanceof SingleEliminationTournament s) {
            s.setHasThirdPlaceMatch(form.getHasThirdPlaceMatch());
        } else if (t instanceof DoubleEliminationTournament d) {
            d.setHasConsolationFinal(form.getHasConsolationFinal());
        } else if (t instanceof RoundRobinTournament r) {
            r.setNumberOfRounds(form.getNumberOfRounds());
            r.setHomeAndAway(form.getHomeAndAway());
        }
        t.setName(form.getName());
        t.setDescription(form.getDescription());
        t.setStartDate(form.getStartDate());
        t.setEndDate(form.getEndDate());
        t.setMaxParticipants(form.getMaxParticipants());
        t.setMatchFormat(form.getMatchFormat());
        t.setRewards(form.getRewards());
        t.setRegistrationStartDate(form.getRegistrationStartDate());
        t.setRegistrationEndDate(form.getRegistrationEndDate());
        t.setGame(gameService.getGameById(form.getGame()).orElse(null));
        t.setGameMode(gameModeService.getAllGameModes().stream().filter(m -> m.getId().equals(form.getGameMode())).findFirst().orElse(null));
        tournamentService.saveTournament(t);
        return "redirect:/tournament/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return "redirect:/tournament/list";
    }
} 