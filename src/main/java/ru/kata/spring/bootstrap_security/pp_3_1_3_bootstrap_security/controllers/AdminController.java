package ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.model.Role;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.model.User;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services.RoleServiceImpl;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services.UserDetailsServiceImpl;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserDetailsServiceImpl userService;
    private final RoleServiceImpl roleServiceImpl;

    @Autowired
    public AdminController(UserDetailsServiceImpl userService, RoleServiceImpl roleServiceImpl) {
        this.userService = userService;
        this.roleServiceImpl = roleServiceImpl;
    }



    @PostMapping("/createNewUser")
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }


    @GetMapping()
    public String showAllUsers(Principal principal, Model model) {
        model.addAttribute("user_auth", userService.findByUsername(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());


        List<Role> roleList = roleServiceImpl.getAllRoles();
        model.addAttribute("user", new User());
        model.addAttribute("list", roleList);
        return "admin/admin";
    }


    @PatchMapping("/{id}/updateUser")
    public String showUpdatedUser(@PathVariable("id") int id, User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}