package vn.codegym.furama_resort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama_resort.model.Service;
import vn.codegym.furama_resort.repository.ServiceRepository;
import vn.codegym.furama_resort.service.ServiceService;

@org.springframework.stereotype.Service
public class ServicesServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.delete(service);
    }

    @Override
    public Page<Service> findAllByNameContaining(String name, Pageable pageable) {
        return serviceRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Iterable<Service> findAll() {
        return serviceRepository.findAll();
    }
}
