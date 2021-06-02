package controller;

import common.Validate;
import model.bean.Customer;
import model.bean.Employee;
import model.bean.Services;
import model.service.CustomerService;
import model.service.ServicesService;
import model.service.impl.CustomerServiceImpl;
import model.service.EmployeeService;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.ServicesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FuramaResortServlet", urlPatterns = {"", "/index"})
public class FuramaResortServlet extends HttpServlet {
    private CustomerService customerService;
    private EmployeeService employeeService;
    private ServicesService servicesService;
    public void init(){
        customerService = new CustomerServiceImpl();
        employeeService = new EmployeeServiceImpl();
        servicesService = new ServicesServiceImpl();
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
                case "search-customer":
                    searchCustomer(request, response);
                    break;
                case "create-employee":
                    addNewEmployee(request, response);
                    break;
                case "edit-employee":
                    updateEmployee(request, response);
                    break;
                case "create-services":
                    addNewServices(request, response);
                    break;
                case "edit-services":
                    updateServices(request, response);
                    break;
//                case "delete-customer":
//                    deleteCustomer(request, response);
//                    break;
                default:
                    searchCustomer(request, response);
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
                case "list-services":
                    listServices(request, response);
                    break;
                case "create-services":
                    addNewServiceForm(request, response);
                    break;
                case "edit-services":
                    updateServicesForm(request, response);
                    break;
                case "delete-services":
                    deleteServices(request, response);
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
        String messageName = Validate.validateCustomerName(name);
        String birthday = request.getParameter("birthday");
//        String messageBirthday = Validate.validateBirthday(birthday);
        int gender = Integer.parseInt(request.getParameter("gender"));
        int idCard = Integer.parseInt(request.getParameter("idCard"));
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(name, birthday, gender, idCard, phone, email, type, address);

        if (messageName == null) {
            customerService.createCustomer(newCustomer);
            newCustomer = null;
            listCustomer(request,response);
        }
//        customerService.createCustomer(newCustomer);
        request.setAttribute("messageName", messageName);
//        request.setAttribute("messageBirthday", messageBirthday);
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

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nameSearch = request.getParameter("searchCustomer");
        List<Customer> customerList = customerService.searchCustomer(nameSearch);

        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/list_customer.jsp").forward(request, response);
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

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nameSearch = request.getParameter("searchEmployee");
        List<Employee> employeeList = employeeService.searchEmployee(nameSearch);

        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list_employee.jsp").forward(request, response);
    }

    private void listServices(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Services> servicesList = servicesService.selectAllServices();
        request.setAttribute("servicesList", servicesList);
        request.getRequestDispatcher("services/list_services.jsp").forward(request, response);
    }

    private void addNewServiceForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("services/add_services.jsp").forward(request, response);
    }

    private void addNewServices(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        String standardRoom = request.getParameter("standardRoom");
        String convenience = request.getParameter("doc");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numOfFloor = Integer.parseInt(request.getParameter("numOfFloor"));

        Services newServices = new Services(name, area, cost, maxPeople, rentType, serviceType, standardRoom, convenience, poolArea, numOfFloor);
        servicesService.createServices(newServices);
        request.setAttribute("msg", "Successfully added new service!");
        request.getRequestDispatcher("services/add_services.jsp").forward(request, response);
    }

    private void deleteServices(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        servicesService.deleteServices(id);
        List<Services> servicesList = servicesService.selectAllServices();

        request.setAttribute("servicesList", servicesList);
        request.getRequestDispatcher("services/list_services.jsp").forward(request, response);
    }

    private void updateServicesForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Services editServices = servicesService.getServicesById(id);

        request.setAttribute("services", editServices);
        request.getRequestDispatcher("services/edit_services.jsp").forward(request, response);
    }

    private void updateServices(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        String standardRoom = request.getParameter("standardRoom");
        String convenience = request.getParameter("doc");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numOfFloor = Integer.parseInt(request.getParameter("numOfFloor"));

        Services services = new Services(id, name, area, cost, maxPeople, rentType, serviceType, standardRoom, convenience, poolArea, numOfFloor);

        servicesService.updateServices(services);
        request.setAttribute("msg", "Successfully updated service!");
        request.getRequestDispatcher("services/edit_services.jsp").forward(request, response);
    }

    private void searchService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nameSearch = request.getParameter("searchServices");
        List<Services> servicesList = servicesService.searchServices(nameSearch);

        request.setAttribute("servicesList", servicesList);
        request.getRequestDispatcher("services/list_services.jsp").forward(request, response);
    }
}
