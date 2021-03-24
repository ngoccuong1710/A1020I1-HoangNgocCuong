package Controllers;

import Commons.FileUtils;
import Models.Customer;

import java.util.*;

public class MainController {
    private static void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Search Employee");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    AddCustomer.addNewCustomer();
                    break;
                case 4:
                    Show.showInformationCustomer();
                    break;
                case 5:
                    AddBooking.addNewBooking();
                    break;
                case 6:
                    Show.showEmployee();
                    break;
                case 7:
                    CabinetsEmployee.searchEmployee();
                    break;
                case 8:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseMenu != 0);
    }
    
    private static void addNewServices(){
        Scanner sc = new Scanner(System.in);
        int chooseServices;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            chooseServices = Integer.parseInt(sc.nextLine());

            switch (chooseServices){
                case 1:
                    AddServices.addNewVilla();
                    break;
                case 2:
                    AddServices.addNewHouse();
                    break;
                case 3:
                    AddServices.addNewRoom();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseServices != 0);
    }

    public static void showServices(){
        Scanner sc = new Scanner(System.in);
        int chooseServices;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Show all Villa");
            System.out.println("2. Show all House");
            System.out.println("3. Show all Room");
            System.out.println("4. Show all Name Villa Not Duplicate");
            System.out.println("5. Show all Name House Not Duplicate");
            System.out.println("6. Show all Name Room Not Duplicate");
            System.out.println("7. Back to menu");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            chooseServices = sc.nextInt();

            switch (chooseServices){
                case 1:
                    Show.showVillaList();
                    break;
                case 2:
                    Show.showHouseList();
                    break;
                case 3:
                    Show.showRoomList();
                    break;
                case 4:
                    FileUtils.readNameFileVilla();
                    break;
                case 5:
                    FileUtils.readNameFileHouse();
                    break;
                case 6:
                    FileUtils.readNameFileRoom();
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseServices != 0);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
