package model.repository;

import model.bean.Services;

import java.sql.SQLException;
import java.util.List;

public interface ServicesRepository {
    List<Services> selectAllServices() throws SQLException;

    void createServices(Services services) throws SQLException;

    boolean deleteServices(int id) throws SQLException;

    boolean updateServices(Services services) throws SQLException;

    Services getServicesById(int id) throws SQLException;

    List<Services> searchServices(String name) throws SQLException;
}
