package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.xoa_phan_tu_khoi_mang;

import java.util.Scanner;

public class XoaPhanTuKhoiMang_v2 {
    public static void main(String[] args) {
        int n, i, c;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n <= 0);

        int arr[] = new int[n];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Nhập số cần xóa: ");
        int index_del = scanner.nextInt();

        for (c = i = 0; i < n; i++) {
            if (arr[i] != index_del) {
                arr[c] = arr[i];
                c++;
            }
        }

        n = c; // lúc này số phần tử trong mảng sẽ bằng c

        System.out.println("Mảng còn lại sau khi xóa phần tử " + index_del + " là: ");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
