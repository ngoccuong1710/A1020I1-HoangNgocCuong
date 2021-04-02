package KiemTra.controller;



import KiemTra.manager.BenhAnManager;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("-CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN-");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách bệnh án");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    BenhAnManager.addMenu();
                    break;
                case 2:
                    BenhAnManager.deleteBenhNhan();
                    break;
                case 3:
                    BenhAnManager.showBanhAn();
                    break;
                case 4:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseMenu != 0);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
