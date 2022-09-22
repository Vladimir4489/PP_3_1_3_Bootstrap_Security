package ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String pageUser(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return ("user");
    }
}