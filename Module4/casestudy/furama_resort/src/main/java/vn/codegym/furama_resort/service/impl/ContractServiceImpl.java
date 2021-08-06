package vn.codegym.furama_resort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.furama_resort.model.Contract;
import vn.codegym.furama_resort.repository.ContractRepository;
import vn.codegym.furama_resort.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }

    @Override
    public Page<Contract> findAllByEmployeeContainingAndCustomerContainingAndServiceContaining(String employee, String customer, String service, Pageable pageable) {
        return contractRepository.findAllByEmployeeContainingAndCustomerContainingAndServiceContaining(employee, customer, service, pageable);
    }

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }
}
