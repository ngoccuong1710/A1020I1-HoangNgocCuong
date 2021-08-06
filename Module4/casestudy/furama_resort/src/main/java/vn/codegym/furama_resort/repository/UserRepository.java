package vn.codegym.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
