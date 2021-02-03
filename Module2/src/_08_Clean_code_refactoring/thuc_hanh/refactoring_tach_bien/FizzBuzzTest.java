package _08_Clean_code_refactoring.thuc_hanh.refactoring_tach_bien;

import java.util.Scanner;

public class FizzBuzzTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số n: ");
        int num = sc.nextInt();

        String result = FizzBuzz.fizzBuzz(num);
        System.out.println(result);
    }
}
