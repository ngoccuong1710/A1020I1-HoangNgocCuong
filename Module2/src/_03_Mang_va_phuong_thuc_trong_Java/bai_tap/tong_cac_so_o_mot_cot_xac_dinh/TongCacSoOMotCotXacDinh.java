package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.tong_cac_so_o_mot_cot_xac_dinh;

import java.util.Scanner;

public class TongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 6, 5},
                {2, 4, 3, 7},
                {9, 1, 4, 5}};
        int sum = 0;
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Tính tổng ở cột mấy?");
        int cot = sc.nextInt(arr[0].length + 1);
        for (i = 0; i < cot; i++) {
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
        }
        System.out.println("Tổng cột thứ " + i + " là: " + sum);
    }
}
