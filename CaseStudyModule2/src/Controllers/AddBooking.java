package Controllers;

import Commons.FileUtils;
import Models.Customer;
import Models.Villa;
import java.util.List;
import java.util.Scanner;

public class AddBooking {
    public static void addNewBooking(){
        Scanner sc = new Scanner(System.in);
        List<Villa> villaList = FileUtils.readFileVilla();
        List<Customer> customerList = FileUtils.readFileCustomer();

        Show.showInformationCustomer();
        System.out.println("Chọn customer: ");
        int chooseCus = Integer.parseInt(sc.nextLine());
        int chooseBooking;
        while (chooseCus == customerList.size()){
            do {
                System.out.println("-----------------------------");
                System.out.println("1. Booking Villa");
                System.out.println("2. Booking House");
                System.out.println("3. Booking Room");
                System.out.println("4. Back to menu");
                System.out.println("5. Exit");
                System.out.print("Choose: ");
                chooseBooking = Integer.parseInt(sc.nextLine());

                switch (chooseBooking){
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        System.out.println("Đã thoát!");
                        System.exit(0);
                }
            }while (chooseBooking != 0);
        }
    }

    public static void boolingVilla(){
        Show.showVillaList();
    }
}
