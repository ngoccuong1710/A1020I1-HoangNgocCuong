package vn.codegym.furama_resort.service;

import vn.codegym.furama_resort.model.User;

public interface UserService {
    Iterable<User> findAll();

    void save(User user);
}
