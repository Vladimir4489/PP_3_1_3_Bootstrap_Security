package ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services;

import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
}