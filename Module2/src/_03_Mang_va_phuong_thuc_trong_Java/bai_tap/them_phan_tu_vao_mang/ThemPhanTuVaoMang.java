package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.them_phan_tu_vao_mang;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.println("Mảng trước khi chèn phần tử:\n " + Arrays.toString(arr));

        System.out.println("Nhập số cần chèn:");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("Nhập vị trí cần chèn:");
        int index = sc.nextInt();

        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = x;

        System.out.println("Mảng sau khi chèn phần tử:\n " + Arrays.toString(arr));
    }
}
