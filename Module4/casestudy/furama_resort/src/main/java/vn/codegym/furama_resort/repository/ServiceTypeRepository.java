package vn.codegym.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
