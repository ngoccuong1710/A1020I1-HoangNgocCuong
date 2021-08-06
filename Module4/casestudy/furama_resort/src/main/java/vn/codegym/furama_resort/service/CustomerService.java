package vn.codegym.furama_resort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama_resort.model.Customer;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);

    void delete(Customer customer);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    Iterable<Customer> findAll();
}
