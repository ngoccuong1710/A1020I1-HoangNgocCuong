package model.service.customer;

import model.bean.customer.Customer;
import model.repository.customer.CustomerRepository;
import model.repository.customer.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> selectAllCustomer() throws SQLException {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        customerRepository.createCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> searchCustomer(String name) throws SQLException {
        return customerRepository.searchCustomer(name);
    }
}
