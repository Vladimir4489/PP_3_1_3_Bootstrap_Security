package ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.repositories.UserRepository;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services.UserDetailsServiceImpl;

import java.security.Principal;

@Controller
public class UserController {
    private final UserDetailsServiceImpl userService;

    @Autowired
    public UserController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String pageUser(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return ("user");
    }
}