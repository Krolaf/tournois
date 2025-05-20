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

import com.java.tournois.entity.Game;
import com.java.tournois.entity.GameFormat;
import com.java.tournois.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/list")
    public String listGames(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Game> gamePage = gameService.getAllGames(page, 5);
        model.addAttribute("gamePage", gamePage);
        return "game/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("formats", GameFormat.values());
        return "game/create";
    }

    @PostMapping("/create")
    public String createGame(@ModelAttribute Game game) {
        gameService.saveGame(game);
        return "redirect:/game/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Game game = gameService.getGameById(id).orElseThrow();
        model.addAttribute("game", game);
        model.addAttribute("formats", GameFormat.values());
        return "game/edit";
    }

    @PostMapping("/edit/{id}")
    public String editGame(@PathVariable Long id, @ModelAttribute Game game) {
        game.setId(id);
        gameService.saveGame(game);
        return "redirect:/game/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return "redirect:/game/list";
    }
} 