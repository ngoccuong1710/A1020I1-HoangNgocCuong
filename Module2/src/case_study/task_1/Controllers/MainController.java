package case_study.task_1.Controllers;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Exit");
            chooseMenu = sc.nextInt();

            switch (chooseMenu){
                case 1:
                    addNewServices();
                    break;
                case 2:

                case 3:

                case 4:

                case 5:

                case 6:

                case 7:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseMenu != 0);
    }

    public static void addNewServices(){
        Scanner sc = new Scanner(System.in);
        int chooseServices;
        do {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            chooseServices = sc.nextInt();

            switch (chooseServices){
                case 1:

                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseServices != 0);
    }
}
