package ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.model.Role;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.model.User;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services.RoleService;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
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


        List<Role> roleList = roleService.getAllRoles();
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