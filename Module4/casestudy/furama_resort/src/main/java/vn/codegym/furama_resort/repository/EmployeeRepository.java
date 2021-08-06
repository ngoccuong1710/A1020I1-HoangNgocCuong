package vn.codegym.furama_resort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
