package model.service.employee;

import model.bean.employee.Employee;
import model.repository.employee.EmployeeRepository;
import model.repository.employee.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> selectAllEmployee() throws SQLException {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        employeeRepository.createEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> searchEmployee(String name) throws SQLException {
        return employeeRepository.searchEmployee(name);
    }
}
