package _03_Mang_va_phuong_thuc_trong_Java.thuc_hanh.tim_gia_tri_trong_mang;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        //Bước 1: Khai báo mảng chứa danh sách sinh viên
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        //Bước 2: Khai báo biến lưu tên tìm kiếm và  gán với giá trị nhập vào
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name’s student:");
        String input_name = scanner.nextLine();
        //Bước 3: Duyệt mảng sinh viên đã khai báo ở trên, tìm phần tử có giá trị bằng với tên đã nhập vào.
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Position of the students in the list " + input_name + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("Not found" + input_name + " in the list.");
    }
}
