package _05_Access_modifier_static_method_static_property.bai_tap.access_modifier;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Radius: ");
        double r = sc.nextInt();

        Circle circle = new Circle(r);
        System.out.println("Diện tích là: " + circle.getArea());
    }
}
