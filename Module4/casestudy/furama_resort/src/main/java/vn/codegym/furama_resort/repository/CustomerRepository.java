package vn.codegym.furama_resort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
