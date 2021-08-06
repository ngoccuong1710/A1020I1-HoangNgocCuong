package vn.codegym.furama_resort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama_resort.model.AttachService;
import vn.codegym.furama_resort.repository.AttachServiceRepository;
import vn.codegym.furama_resort.service.AttachServiceService;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public Iterable<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
