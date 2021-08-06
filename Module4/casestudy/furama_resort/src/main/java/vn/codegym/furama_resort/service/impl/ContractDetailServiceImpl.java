package vn.codegym.furama_resort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama_resort.model.ContractDetail;
import vn.codegym.furama_resort.repository.ContractDetailRepository;
import vn.codegym.furama_resort.service.ContractDetailService;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
