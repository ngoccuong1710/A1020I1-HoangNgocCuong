package vn.codegym.furama_resort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.Employee;
import vn.codegym.furama_resort.model.Service;

public interface ServiceRepository extends JpaRepository<Service, String> {
    Page<Service> findAllByNameContaining(String name, Pageable pageable);
}
