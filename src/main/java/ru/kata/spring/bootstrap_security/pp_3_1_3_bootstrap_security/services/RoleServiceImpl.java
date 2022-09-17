package ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services;

import org.springframework.stereotype.Service;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.model.Role;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    public Optional<Role> getRole(int id){
        return roleRepository.findById(id);
    }
}