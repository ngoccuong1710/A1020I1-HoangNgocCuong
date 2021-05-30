package model.service.impl;

import model.bean.Services;
import model.repository.ServicesRepository;
import model.repository.impl.ServicesRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ServicesServiceImpl implements model.service.ServicesService {
    private ServicesRepository servicesRepository = new ServicesRepositoryImpl();
    @Override
    public List<Services> selectAllServices() throws SQLException {
        return servicesRepository.selectAllServices();
    }

    @Override
    public void createServices(Services services) throws SQLException {
        servicesRepository.createServices(services);
    }

    @Override
    public boolean deleteServices(int id) throws SQLException {
        return servicesRepository.deleteServices(id);
    }

    @Override
    public boolean updateServices(Services services) throws SQLException {
        return servicesRepository.updateServices(services);
    }

    @Override
    public Services getServicesById(int id) throws SQLException {
        return servicesRepository.getServicesById(id);
    }

    @Override
    public List<Services> searchServices(String name) throws SQLException {
        return servicesRepository.searchServices(name);
    }
}
