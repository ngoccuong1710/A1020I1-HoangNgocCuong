package _08_Clean_code_refactoring.thuc_hanh.refactoring_tach_phuong_thuc;

import java.util.Scanner;

public class CylinderTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập radius:");
        int radius = sc.nextInt();
        System.out.println("Nhập height:");
        int height = sc.nextInt();
        System.out.println("Volume:");
        double resultVol = Cylinder.getVolume(radius, height);
        System.out.println(resultVol);
    }
}
