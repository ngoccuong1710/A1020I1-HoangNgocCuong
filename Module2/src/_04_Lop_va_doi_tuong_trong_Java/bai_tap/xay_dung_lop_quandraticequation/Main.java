package _04_Lop_va_doi_tuong_trong_Java.bai_tap.xay_dung_lop_quandraticequation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số a");
        double a = sc.nextInt();
        System.out.println("Nhập số b");
        double b = sc.nextInt();
        System.out.println("Nhập số c");
        double c = sc.nextInt();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        if (quadraticEquation.getA() != 0) {
            if (quadraticEquation.getDiscriminant() < 0) {
                System.out.println("The equation há no roots");
            } else if (quadraticEquation.getDiscriminant() == 0) {
                System.out.println("Phương trình có nghiệm kép: " + quadraticEquation.getNghiemKep());
            } else {
                System.out.println("Phương trình có 2 nghiệm " + "\nNghiệm 1: " + quadraticEquation.getRoot1() +
                        "\nNghiệm 2: " + quadraticEquation.getRoot2());
            }
        }
        else System.out.println("Phương trình có 1 nghiệm: " + quadraticEquation.get1Nghiem());
    }
}
