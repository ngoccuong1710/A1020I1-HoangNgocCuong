package vn.codegym.furama_resort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama_resort.model.Service;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    Service findById(String id);

    void save(Service service);

    void delete(Service service);

    Page<Service> findAllByNameContaining(String name, Pageable pageable);

    Iterable<Service> findAll();
}
