package vn.codegym.furama_resort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.furama_resort.model.Contract;
import vn.codegym.furama_resort.model.Customer;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByEmployeeContainingAndCustomerContainingAndServiceContaining(String employee, String customer, String service, Pageable pageable);
}
