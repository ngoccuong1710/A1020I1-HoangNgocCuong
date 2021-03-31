package QuanLyPhuongTienGiaoThong.controller;

import QuanLyPhuongTienGiaoThong.manager.ManagerPhuongTien;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Thoát");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    addMenu();
                    break;
                case 2:
                    ManagerPhuongTien.showMenu();
                    break;
                case 3:
                    ManagerPhuongTien.deleteMenu();
                    break;
                case 4:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseMenu != 0);
    }

    private static void addMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("1. Thêm xe tải");
            System.out.println("2. Thêm ô tô");
            System.out.println("3. Thêm xe máy");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    ManagerPhuongTien.addXeTai();
                    break;
                case 2:
                    ManagerPhuongTien.addOTo();
                    break;
                case 3:
                    ManagerPhuongTien.addXeMay();
                    break;
            }
        }while (chooseMenu != 0);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
