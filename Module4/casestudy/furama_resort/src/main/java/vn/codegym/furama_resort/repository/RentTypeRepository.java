package vn.codegym.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.RentType;

public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}
