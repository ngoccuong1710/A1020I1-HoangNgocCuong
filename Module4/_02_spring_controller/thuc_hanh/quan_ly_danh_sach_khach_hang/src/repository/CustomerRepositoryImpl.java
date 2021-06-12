package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(0, "Cuong", "cuong@gmail.com", "danang"));
        customerList.add(new Customer(1, "Danh", "danh@gmail.com", "hanoi"));
        customerList.add(new Customer(2, "Hieu", "hieu@gmail.com", "hue"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer.getId(), customer);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.set(id, customer);
    }


}
