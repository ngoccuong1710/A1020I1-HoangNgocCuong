package Controllers;

import Commons.FileUtils;
import Models.Employee;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CabinetsEmployee {
    public static void searchEmployee(){
        List<Employee> employeeList = FileUtils.readFileEmployee();
        Stack<Employee> employeeStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        for (Employee employee: employeeList){
            employeeStack.push(employee);
        }

        System.out.println("Nhập tên cần tìm: ");
        String empSearch = sc.nextLine();
        for (Employee employee: employeeStack){
            if (employee.getNameEmp().contains(empSearch)){
                System.out.println("Nhân viên ở vị trí: " + employeeStack.search(employee));
                System.out.println(employee);
            }
        }
    }

}
