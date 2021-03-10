package _15_xu_li_ngoai_le_debug.bai_tap.su_dung_lop_illegaltriangleexception;

import java.util.Scanner;

public class Main {

    public static boolean checkCanhAm(int a, int b, int c) throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0){
            throw  new IllegalTriangleException();
        }
        return true;
    }

    public static boolean checkTongCanh(int a, int b, int c) throws IllegalTriangleException {
        if (a + b < c || a + c < b || b + c < a){
            throw  new IllegalTriangleException();
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập cạnh a: ");
        int a = sc.nextInt();
        System.out.println("Nhập cạnh b: ");
        int b = sc.nextInt();
        System.out.println("Nhập cạnh c: ");
        int c = sc.nextInt();
        try{
            if (checkCanhAm(a, b, c) && checkTongCanh(a, b, c)){
                System.out.println("Tam giác có 3 cạnh: " + a + ", " + b + ", " + c);
            }
        }catch (IllegalTriangleException e){
            System.err.println("Lỗi");
        }

    }
}
