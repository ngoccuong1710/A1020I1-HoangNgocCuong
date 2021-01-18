package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.dem_so_lan_xuat_hien_trong_chuoi;

import java.util.Scanner;

public class DemSoLanXuatHienTrongChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = sc.nextLine();
        System.out.println("Kí tự cần đến: ");
        char c = sc.next().charAt(0);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                result ++;
            }
        }
        System.out.print("Số lần xuất hiện: " + result);
    }
}
