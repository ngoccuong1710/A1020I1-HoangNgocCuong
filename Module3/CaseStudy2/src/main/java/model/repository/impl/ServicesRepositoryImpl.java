package model.repository.impl;

import model.bean.Services;
import model.repository.ServicesRepository;
import model.repository.base.BaseRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesRepositoryImpl implements ServicesRepository {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Services> selectAllServices() throws SQLException {
        List<Services> servicesList = new ArrayList<>();
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call service_list;");
        ResultSet resultSet = callableStatement.executeQuery();
        Services services = null;
        while (resultSet.next()){
            services = new Services();
            services.setId(resultSet.getInt("service_id"));
            services.setName(resultSet.getString("service_name"));
            services.setArea(resultSet.getString("service_area"));
            services.setCost(resultSet.getInt("service_cost"));
            services.setMaxPeople(resultSet.getInt("service_max_people"));
            services.setRentType(resultSet.getInt("rent_type_id"));
            services.setServiceType(resultSet.getInt("service_type_id"));
            services.setStandardRoom(resultSet.getString("standard_room"));
            services.setDecriptionOtherConvenience(resultSet.getString("decription_other_convenience"));
            services.setPoolArea(resultSet.getDouble("pool_area"));
            services.setNumOfFloors(resultSet.getInt("number_of_floors"));

            servicesList.add(services);

        }
        return servicesList;
    }

    @Override
    public void createServices(Services services) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call service_create(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        callableStatement.setString(1, services.getName());
        callableStatement.setString(2, services.getArea());
        callableStatement.setDouble(3, services.getCost());
        callableStatement.setDouble(4, services.getMaxPeople());
        callableStatement.setInt(5, services.getRentType());
        callableStatement.setInt(6, services.getServiceType());
        callableStatement.setString(7, services.getStandardRoom());
        callableStatement.setString(8, services.getDecriptionOtherConvenience());
        callableStatement.setDouble(9, services.getPoolArea());
        callableStatement.setInt(10, services.getNumOfFloors());
        callableStatement.executeUpdate();
    }

    @Override
    public boolean deleteServices(int id) throws SQLException {
        boolean rowDeleted = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call service_delete(?);");
        callableStatement.setInt(1, id);
        rowDeleted = callableStatement.executeUpdate() > 0;
        return rowDeleted;
    }

    @Override
    public boolean updateServices(Services services) throws SQLException {
        boolean rowUpdated = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call service_update(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        callableStatement.setInt(1, services.getId());
        callableStatement.setString(2, services.getName());
        callableStatement.setString(3, services.getArea());
        callableStatement.setDouble(4, services.getCost());
        callableStatement.setDouble(5, services.getMaxPeople());
        callableStatement.setInt(6, services.getRentType());
        callableStatement.setInt(7, services.getServiceType());
        callableStatement.setString(8, services.getStandardRoom());
        callableStatement.setString(9, services.getDecriptionOtherConvenience());
        callableStatement.setDouble(10, services.getPoolArea());
        callableStatement.setInt(11, services.getNumOfFloors());
        rowUpdated = callableStatement.executeUpdate() > 0;
        return rowUpdated;
    }

    @Override
    public Services getServicesById(int id) throws SQLException {
        Services services = null;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_service_by_id(?);");
        callableStatement.setInt(1, id);
        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("service_name");
            String area = resultSet.getString("service_area");
            double cost = resultSet.getInt("service_cost");
            int maxPeople = resultSet.getInt("service_max_people");
            int rentType = resultSet.getInt("rent_type_id");
            int serviceType = resultSet.getInt("service_type_id");
            String standardRoom = resultSet.getString("standard_room");
            String convenience = resultSet.getString("decription_other_convenience");
            double poolArea = resultSet.getDouble("pool_area");
            int numOfFloor = resultSet.getInt("number_of_floors");

            services = new Services(id, name, area, cost, maxPeople, rentType, serviceType, standardRoom, convenience, poolArea, numOfFloor);
        }
        return services;
    }

    @Override
    public List<Services> searchServices(String name) throws SQLException {
        return null;
    }
}
