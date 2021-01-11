package _01_Introduction_to_Java.bai_tap.chuyen_doi_tien_te;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền USD:");
        usd = sc.nextDouble();
        double quyDoi = usd * 23000;
        System.out.println("Giá trị VND là: " + quyDoi);
    }
}
