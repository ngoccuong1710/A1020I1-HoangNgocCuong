package _02_Vong_lap_trong_Java.bai_tap.hien_thi_cac_so_nguyen_so_nho_hon_100;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        int count = 0;
        int i = 1;

        while (true) {

            if (isPrimeNumber(i)) {
                System.out.print(i + ", ");
                count++;
            }
            i++;

            if (i > 100) {
                break;
            }
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
