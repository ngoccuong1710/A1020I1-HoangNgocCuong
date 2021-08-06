package vn.codegym.furama_resort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.furama_resort.model.Contract;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    Contract findById(Integer id);

    void save(Contract contract);

    void delete(Contract contract);

    Page<Contract> findAllByEmployeeContainingAndCustomerContainingAndServiceContaining(String employee, String customer, String service, Pageable pageable);

    Iterable<Contract> findAll();
}
