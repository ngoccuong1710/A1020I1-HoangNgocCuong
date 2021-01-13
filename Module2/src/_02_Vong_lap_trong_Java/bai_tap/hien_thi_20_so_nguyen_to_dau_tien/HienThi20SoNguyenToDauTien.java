package _02_Vong_lap_trong_Java.bai_tap.hien_thi_20_so_nguyen_to_dau_tien;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input n: ");
        int n = input.nextInt();

        int count = 0;
        int i = 1;

        while (true) {

            if (isPrimeNumber(i)) {
                System.out.print(i + ", ");
                count++;
            }

            if (count == n) {
                break;
            }

            i++;
        }
    }

    static boolean isPrimeNumber(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }
}
