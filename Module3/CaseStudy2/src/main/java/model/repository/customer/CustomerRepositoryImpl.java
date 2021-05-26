package model.repository.customer;

import model.bean.customer.Customer;
import model.repository.BaseRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> selectAllCustomer() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call customer_list;");
        ResultSet resultSet = callableStatement.executeQuery();
        Customer customer = null;
        while (resultSet.next()){
            customer = new Customer();
            customer.setId(resultSet.getInt("customer_id"));
            customer.setName(resultSet.getString("customer_name"));
            customer.setBirthday(resultSet.getString("customer_birthday"));
            customer.setGender(resultSet.getBoolean("customer_gender"));
            customer.setIdCard(resultSet.getInt("customer_id_card"));
            customer.setPhone(resultSet.getInt("customer_phone"));
            customer.setEmail(resultSet.getString("customer_email"));
            customer.setType(resultSet.getString("customer_type_name"));
            customer.setAddress(resultSet.getString("customer_address"));

            customerList.add(customer);

        }
        return customerList;
    }

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call customer_create(?, ?, ?, ?, ?, ?, ?, ?);");
        callableStatement.setString(1, customer.getName());
        callableStatement.setString(2, customer.getBirthday());
        callableStatement.setBoolean(3, customer.getGender());
        callableStatement.setInt(4, customer.getIdCard());
        callableStatement.setInt(5, customer.getPhone());
        callableStatement.setString(6, customer.getEmail());
        callableStatement.setString(7, customer.getType());
        callableStatement.setString(8, customer.getAddress());
        callableStatement.executeUpdate();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call customer_delete(?);");
        callableStatement.setInt(1, id);
        rowDeleted = callableStatement.executeUpdate() > 0;
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call customer_update(?, ?, ?, ?, ?, ?, ?, ?, ?);");
        callableStatement.setInt(1, customer.getId());
        callableStatement.setString(2, customer.getName());
        callableStatement.setString(3, customer.getBirthday());
        callableStatement.setBoolean(4, customer.getGender());
        callableStatement.setInt(5, customer.getIdCard());
        callableStatement.setInt(6, customer.getPhone());
        callableStatement.setString(7, customer.getEmail());
        callableStatement.setString(8, customer.getType());
        callableStatement.setString(9, customer.getAddress());
        rowUpdated = callableStatement.executeUpdate() > 0;
        return rowUpdated;
    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        Customer customer = null;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_customer_by_id(?);");
        callableStatement.setInt(1, id);
        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()){
            String name =  resultSet.getString("customer_name");
            String birthday = resultSet.getString("customer_birthday");
            boolean gender = resultSet.getBoolean("customer_gender");
            int idCard = resultSet.getInt("customer_id_card");
            int phone = resultSet.getInt("customer_phone");
            String email = resultSet.getString("customer_email");
            String type = resultSet.getString("customer_type_name");
            String address =  resultSet.getString("customer_address");

            customer = new Customer(id, name, birthday, gender, idCard, phone, email, type, address);
        }
        return customer;
    }

    @Override
    public List<Customer> searchCustomer(String name) throws SQLException {
        return null;
    }
}
