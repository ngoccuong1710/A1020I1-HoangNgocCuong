package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.tim_gia_tri_nho_nhat_trong_mang;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử trong mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++){
            System.out.printf("a[%d] = ", i);
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        for (int i = 0; i < n; i++){
            if (min > arr[i]){
                arr[i] = min;
            }
        }
        System.out.println("Phần tử nhỏ nhất trong mảng là: " + min);
    }
}
