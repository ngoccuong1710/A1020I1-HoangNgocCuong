package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.gop_mang;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử mảng 1: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Nhập các phần tử của mảng 1: ");
        for (int i = 0; i < n; i++){
            System.out.printf("a[%d] = ", i);
            arr1[i] = sc.nextInt();
        }
        System.out.println("Nhập số phần tử mảng 2: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Nhập các phần tử của mảng 2: ");
        for (int i = 0; i < m; i++){
            System.out.printf("a[%d] = ", i);
            arr2[i] = sc.nextInt();
        }

        int count = 0;
        int[] arr3 = new int[n + m];
        for (int i = 0; i < n; i++){
            arr3[i] = arr1[i];
            count++;
        }
        for (int i = 0; i < m; i++){
                arr3[count++] = arr2[i];
        }

        System.out.println("Mảng sau khi gộp là:\n " + Arrays.toString(arr3));
    }
}
