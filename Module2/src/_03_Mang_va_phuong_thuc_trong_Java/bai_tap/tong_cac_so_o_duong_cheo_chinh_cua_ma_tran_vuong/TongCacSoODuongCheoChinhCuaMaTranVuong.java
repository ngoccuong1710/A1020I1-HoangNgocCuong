package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.tong_cac_so_o_duong_cheo_chinh_cua_ma_tran_vuong;

public class TongCacSoODuongCheoChinhCuaMaTranVuong {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 6},
                {2, 4, 3},
                {9, 1, 4}};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Tổng đường chéo chính của ma trận vuông là: " + sum);
    }
}
