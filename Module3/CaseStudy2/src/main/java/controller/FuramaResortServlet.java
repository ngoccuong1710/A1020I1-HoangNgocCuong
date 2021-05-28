package controller;

import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.service.customer.CustomerService;
import model.service.customer.CustomerServiceImpl;
import model.service.employee.EmployeeService;
import model.service.employee.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class FuramaResortServlet extends HttpServlet {
    private CustomerService customerService;
    private EmployeeService employeeService;
    public void init(){
        customerService = new CustomerServiceImpl();
        employeeService = new EmployeeServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action = "";
        }
        try{
            switch (action) {
                case "create-customer":
                    addNewCustomer(request, response);
                    break;
                case "edit-customer":
                    updateCustomer(request, response);
                    break;
                case "create-employee":
                    addNewEmployee(request, response);
                    break;
                case "edit-employee":
                    updateEmployee(request, response);
                    break;
                default:
                    home(request, response);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try{
            switch (action) {
                case "list-customer":
                    listCustomer(request, response);
                    break;
                case "create-customer":
                    addNewCustomerForm(request, response);
                    break;
                case "edit-customer":
                    updateCustomerForm(request, response);
                    break;
                case "delete-customer":
                    deleteCustomer(request, response);
                    break;
                case "list-employee":
                    listEmployee(request, response);
                    break;
                case "create-employee":
                    addNewEmployeeForm(request, response);
                    break;
                case "edit-employee":
                    updateEmployeeForm(request, response);
                    break;
                case "delete-employee":
                    deleteEmployee(request, response);
                    break;
                default:
                    home(request, response);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/list_customer.jsp").forward(request, response);
    }

    private void addNewCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("customer/add_customer.jsp").forward(request, response);
    }

    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int idCard = Integer.parseInt(request.getParameter("idCard"));
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String address = request.getParameter("address");

        Customer newCustomer = new Customer(name, birthday, gender, idCard, phone, email, type, address);
        customerService.createCustomer(newCustomer);
        request.setAttribute("msg", "Successfully added new customers!");
        request.getRequestDispatcher("customer/add_customer.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        customerService.deleteCustomer(id);
        List<Customer> customerList = customerService.selectAllCustomer();

        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/list_customer.jsp").forward(request, response);
    }

    private void updateCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer editCustomer = customerService.getCustomerById(id);

        request.setAttribute("customer", editCustomer);
        request.getRequestDispatcher("customer/edit_customer.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int idCard = Integer.parseInt(request.getParameter("idCard"));
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String address = request.getParameter("address");

        Customer Customer = new Customer(id, name, birthday, gender, idCard, phone, email, type, address);

        customerService.updateCustomer(Customer);
        request.setAttribute("msg", "Successfully updated customers!");
        request.getRequestDispatcher("customer/edit_customer.jsp").forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request, response);
    }

    private void addNewEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("employee/add_employee.jsp").forward(request, response);
    }

    private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int idCard = Integer.parseInt(request.getParameter("idCard"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String educationDegree = request.getParameter("educationDegree");
        String division = request.getParameter("division");
        String username = request.getParameter("username");

        Employee newEmployee = new Employee(name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, username);
        employeeService.createEmployee(newEmployee);
        request.setAttribute("msg", "Successfully added new employee!");
        request.getRequestDispatcher("employee/add_employee.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        employeeService.deleteEmployee(id);
        List<Employee> employeeList = employeeService.selectAllEmployee();

        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request, response);
    }

    private void updateEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee editEmployee = employeeService.getEmployeeById(id);

        request.setAttribute("employee", editEmployee);
        request.getRequestDispatcher("employee/edit_employee.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int idCard = Integer.parseInt(request.getParameter("idCard"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String educationDegree = request.getParameter("educationDegree");
        String division = request.getParameter("division");
        String username = request.getParameter("username");

        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, username);

        employeeService.updateEmployee(employee);
        request.setAttribute("msg", "Successfully updated employee!");
        request.getRequestDispatcher("employee/edit_employee.jsp").forward(request, response);
    }
}
