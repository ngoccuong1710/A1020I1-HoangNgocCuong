package _06_Ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 3 cạnh: ");
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập màu: ");
        String color = sc.nextLine();
        Triangle triangle = new Triangle(a, b, c, color);
        System.out.println(triangle);
    }
}
