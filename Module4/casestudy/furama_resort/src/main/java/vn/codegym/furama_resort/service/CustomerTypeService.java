package vn.codegym.furama_resort.service;

import vn.codegym.furama_resort.model.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAll();
}
