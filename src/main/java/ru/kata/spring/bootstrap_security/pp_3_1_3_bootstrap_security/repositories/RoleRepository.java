package ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}