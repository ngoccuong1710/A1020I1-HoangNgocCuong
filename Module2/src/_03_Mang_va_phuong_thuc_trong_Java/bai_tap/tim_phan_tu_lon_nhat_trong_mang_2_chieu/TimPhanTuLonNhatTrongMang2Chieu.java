package _03_Mang_va_phuong_thuc_trong_Java.bai_tap.tim_phan_tu_lon_nhat_trong_mang_2_chieu;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 3, 4, 5},
                {9, 2, 6, 8}};

        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất là: " + max);
    }
}
