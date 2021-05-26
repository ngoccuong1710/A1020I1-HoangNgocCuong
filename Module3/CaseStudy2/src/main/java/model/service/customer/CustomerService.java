package model.service.customer;

import model.bean.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    List<Customer> selectAllCustomer() throws SQLException;

    void createCustomer(Customer customer) throws SQLException;

    boolean deleteCustomer(int id) throws SQLException;

    boolean updateCustomer(Customer customer) throws SQLException;

    Customer getCustomerById(int id) throws SQLException;

    List<Customer> searchCustomer(String name) throws SQLException;
}
