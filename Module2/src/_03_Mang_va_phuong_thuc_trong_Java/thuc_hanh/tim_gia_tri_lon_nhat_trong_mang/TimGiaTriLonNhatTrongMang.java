package _03_Mang_va_phuong_thuc_trong_Java.thuc_hanh.tim_gia_tri_lon_nhat_trong_mang;

import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
//Bước 1: Khai báo các biến, nhập và kiểm tra kích thước mảng
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
//Bước 2: Nhập giá trị cho các phần tử của mảng
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
//Bước 3: In ra danh sách tài sản đã nhập
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
//Bước 4: Duyệt các phần tử trong mảng để tìm GTLN và vị trí
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
