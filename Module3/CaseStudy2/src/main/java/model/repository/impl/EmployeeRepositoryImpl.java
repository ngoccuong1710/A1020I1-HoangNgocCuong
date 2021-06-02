package model.repository.impl;

import model.bean.Employee;
import model.repository.base.BaseRepository;
import model.repository.EmployeeRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Employee> selectAllEmployee() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call employee_list;");
        ResultSet resultSet = callableStatement.executeQuery();
        Employee employee = null;
        while (resultSet.next()){
            employee = new Employee();
            employee.setId(resultSet.getInt("employee_id"));
            employee.setName(resultSet.getString("employee_name"));
            employee.setBirthday(resultSet.getString("employee_birthday"));
            employee.setIdCard(resultSet.getInt("employee_id_card"));
            employee.setSalary(resultSet.getDouble("employee_salary"));
            employee.setPhone(resultSet.getInt("employee_phone"));
            employee.setEmail(resultSet.getString("employee_email"));
            employee.setAddress(resultSet.getString("employee_address"));
            employee.setPosition(resultSet.getString("position_name"));
            employee.setEducationDegree(resultSet.getString("education_degree_name"));
            employee.setDivision(resultSet.getString("division_name"));

            employeeList.add(employee);

        }
        return employeeList;
    }

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call employee_create(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        callableStatement.setString(1, employee.getName());
        callableStatement.setString(2, employee.getBirthday());
        callableStatement.setInt(3, employee.getIdCard());
        callableStatement.setDouble(4, employee.getSalary());
        callableStatement.setInt(5, employee.getPhone());
        callableStatement.setString(6, employee.getEmail());
        callableStatement.setString(7, employee.getAddress());
        callableStatement.setString(8, employee.getPosition());
        callableStatement.setString(9, employee.getEducationDegree());
        callableStatement.setString(10, employee.getDivision());
        callableStatement.setString(11, employee.getUsername());
        callableStatement.executeUpdate();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call employee_delete(?);");
        callableStatement.setInt(1, id);
        rowDeleted = callableStatement.executeUpdate() > 0;
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call employee_update(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        callableStatement.setInt(1, employee.getId());
        callableStatement.setString(2, employee.getName());
        callableStatement.setString(3, employee.getBirthday());
        callableStatement.setInt(4, employee.getIdCard());
        callableStatement.setDouble(5, employee.getSalary());
        callableStatement.setInt(6, employee.getPhone());
        callableStatement.setString(7, employee.getEmail());
        callableStatement.setString(8, employee.getAddress());
        callableStatement.setString(9, employee.getPosition());
        callableStatement.setString(10, employee.getEducationDegree());
        callableStatement.setString(11, employee.getDivision());
        callableStatement.setString(12, employee.getUsername());
        rowUpdated = callableStatement.executeUpdate() > 0;
        return rowUpdated;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        Employee employee = null;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_employee_by_id(?);");
        callableStatement.setInt(1, id);
        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()){
            String name =  resultSet.getString("employee_name");
            String birthday = resultSet.getString("employee_birthday");
            int idCard = resultSet.getInt("employee_id_card");
            double salary = resultSet.getDouble("employee_salary");
            int phone = resultSet.getInt("employee_phone");
            String email = resultSet.getString("employee_email");
            String address =  resultSet.getString("employee_address");
            String position = resultSet.getString("position_name");
            String educationDegree = resultSet.getString("education_degree_name");
            String division = resultSet.getString("division_name");
            String username = resultSet.getString("username");

            employee = new Employee(id, name, birthday, idCard, salary, phone, email,address, position, educationDegree, division, username);
        }
        return employee;
    }

    @Override
    public List<Employee> searchEmployee(String keywork) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try{
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call search_employee(?);");
            callableStatement.setString(1, keywork);
            ResultSet resultSet = callableStatement.executeQuery();

            Employee employee = null;
            while (resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setBirthday(resultSet.getString("employee_birthday"));
                employee.setIdCard(resultSet.getInt("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setPhone(resultSet.getInt("employee_phone"));
                employee.setEmail(resultSet.getString("employee_email"));
                employee.setAddress(resultSet.getString("employee_address"));
                employee.setPosition(resultSet.getString("position_name"));
                employee.setEducationDegree(resultSet.getString("education_degree_name"));
                employee.setDivision(resultSet.getString("division_name"));

                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}
