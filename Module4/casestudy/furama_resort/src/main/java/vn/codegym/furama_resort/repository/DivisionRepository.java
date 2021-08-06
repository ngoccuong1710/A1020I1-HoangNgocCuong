package vn.codegym.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
}
