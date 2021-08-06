package vn.codegym.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
