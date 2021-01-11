package _01_Introduction_to_Java.thuc_hanh.su_dung_toan_tu;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = sc.nextFloat();

        System.out.println("Enter height: ");
        height = sc.nextFloat();

        float area = width * height;

        System.out.println("Area is: " + area);
    }
}
