package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.SmartPhone;
import vn.codegym.repository.SmartPhoneRepository;

import java.util.List;

@Service("SmartPhoneService")
public class SmartPhoneServiceImpl implements SmartPhoneService{
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(SmartPhone phone) {
        smartPhoneRepository.save(phone);
    }

    @Override
    public SmartPhone remove(Integer id) {
        SmartPhone smartphone = findById(id);
        smartPhoneRepository.deleteById(id);
        return smartphone;
    }
}
