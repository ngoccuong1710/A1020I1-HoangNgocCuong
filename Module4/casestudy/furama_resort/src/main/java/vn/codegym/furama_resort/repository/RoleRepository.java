package vn.codegym.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
