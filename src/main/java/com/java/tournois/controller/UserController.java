package com.java.tournois.controller;

import com.java.tournois.entity.User;
import com.java.tournois.entity.UserRole;
import com.java.tournois.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUsers(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<User> userPage = userService.getAllUsers(page, 5);
        model.addAttribute("userPage", userPage);
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", UserRole.values());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id).orElseThrow();
        model.addAttribute("user", user);
        model.addAttribute("roles", UserRole.values());
        return "user/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }
} 