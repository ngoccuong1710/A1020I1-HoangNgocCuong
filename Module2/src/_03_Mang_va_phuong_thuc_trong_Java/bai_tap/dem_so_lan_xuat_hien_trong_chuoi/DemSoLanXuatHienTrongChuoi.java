package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.dem_so_lan_xuat_hien_trong_chuoi;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DemSoLanXuatHienTrongChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = sc.nextLine();
        System.out.println("Kí tự cần đến: ");
        char c = sc.next().charAt(0);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                result++;
            }
        }

        System.out.print("Số lần xuất hiện: " + result);

    }

//    boolean check(int arr[]){
//        int a = 0;
//        Set<Integer> list = new TreeSet<>();
//        for (int i : arr){
//            list.add(i);
//        }
//        for (int i : arr){
//            if (i == arr[0]){
//                a++;
//            }
//        }
//        if (arr.length == list.size()){
//            return true;
//        }
//        else return false;
//    }
}
