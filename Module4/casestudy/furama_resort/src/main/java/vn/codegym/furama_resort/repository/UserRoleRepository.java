package vn.codegym.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.Role;
import vn.codegym.furama_resort.model.User;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByUsers(User user);
}
