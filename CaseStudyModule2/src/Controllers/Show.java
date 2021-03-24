package Controllers;

import Commons.FileUtils;
import Models.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {
    public static void showVillaList(){
        List<Villa> villaList = FileUtils.readFileVilla();
        for (int i = 0; i < villaList.size(); i++){
            System.out.println((1 + i) + " -----------------" + villaList.get(i)+ "\n");
        }
    }

    public static void showHouseList(){
        List<House> houseList = FileUtils.readFileHouse();
        for (int i = 0; i < houseList.size(); i++){
            System.out.println((1 + i) + " -----------------" + houseList.get(i)+ "\n");
        }
    }

    public static void showRoomList(){
        List<Room> roomList = FileUtils.readFileRoom();
        for (int i = 0; i < roomList.size(); i++){
            System.out.println((1 + i) + " -----------------" + roomList.get(i)+ "\n");
        }
    }

    public static void showInformationCustomer(){
        List<Customer> customerList = FileUtils.readFileCustomer();
        Collections.sort(customerList, new SortCustomer());
        for (int i = 0; i < customerList.size(); i++){
            System.out.println((1 + i) + " -----------------" + customerList.get(i)+ "\n");
        }
    }

    public static void showEmployee(){
        List<Employee> employeeList = FileUtils.readFileEmployee();
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employeeList.size(); i++){
            map.put((i+1), employeeList.get(i));
        }
        for (Map.Entry<Integer, Employee> entry : map.entrySet()){
            System.out.println(entry.getKey() + ".\t" + entry.getValue());
        }
    }
}
