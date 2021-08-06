package vn.codegym.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
