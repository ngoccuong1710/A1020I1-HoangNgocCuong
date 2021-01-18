package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.xoa_phan_tu_khoi_mang;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.println("Mảng trước khi xóa phần tử:\n " + Arrays.toString(arr));

        System.out.println("Nhập phần tử cần xóa:");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        for (int i = x; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }

        System.out.println("Mảng sau khi xóa phần tử:\n " + Arrays.toString(arr));
    }
}
