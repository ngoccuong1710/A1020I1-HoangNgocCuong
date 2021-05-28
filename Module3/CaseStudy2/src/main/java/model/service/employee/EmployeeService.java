package model.service.employee;

import model.bean.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    List<Employee> selectAllEmployee() throws SQLException;

    void createEmployee(Employee employee) throws SQLException;

    boolean deleteEmployee(int id) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;

    Employee getEmployeeById(int id) throws SQLException;

    List<Employee> searchEmployee(String name) throws SQLException;
}
