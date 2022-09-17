package ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.services;

import ru.kata.spring.bootstrap_security.pp_3_1_3_bootstrap_security.model.User;

import java.util.List;

public interface UserService {
    boolean save(User user);
    List<User> getAllUsers();
    User update(User user);
    User getById(int id);
    boolean delete(int id);
    User findByUsername(String name);

}