package vn.codegym.service;

import vn.codegym.model.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    List<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    void save(SmartPhone phone);
    SmartPhone remove(Integer id);
}
