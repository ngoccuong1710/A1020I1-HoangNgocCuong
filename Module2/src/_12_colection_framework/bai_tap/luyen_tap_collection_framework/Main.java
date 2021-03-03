package _12_colection_framework.bai_tap.luyen_tap_collection_framework;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo id");
            System.out.println("3. Xóa sản phẩm theo id");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    ProductManager.themSP(sc);
                    break;
                case 2:
                    ProductManager.suaSPTheoId(sc);
                    break;
                case 3:
                    ProductManager.xoaSPTheoId(sc);
                    break;
                case 4:
                    ProductManager.hienThiSP();
                    break;
                case 5:
                    ProductManager.timKIemSPTheoTen(sc);
                    break;
                case 6:
                    displayTangGiamMenu();
            }
        }while (chooseMenu != 0);
    }

    public static void displayTangGiamMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("--------------------");
            System.out.println("1. Sắp xếp tăng dần");
            System.out.println("2. Sắp xếp giảm dần");
            System.out.println("3. Quay lại menu");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    ProductManager.sapXepTangTheoGia();
                    break;
                case 2:
                    ProductManager.sapXepGiamTheoGia();
                    break;
                case 3:
                    displayMainMenu();
            }
        }while (chooseMenu != 0);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
