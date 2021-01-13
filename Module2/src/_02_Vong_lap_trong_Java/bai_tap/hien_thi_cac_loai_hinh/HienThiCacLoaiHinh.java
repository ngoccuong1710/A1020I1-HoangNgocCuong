package _02_Vong_lap_trong_Java.bai_tap.hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Hiển thị hình chữ nhật.\n" +
                "2. Hiển thị tam giác vuông có cạnh góc vuông ở botton-left.\n" +
                "3. Hiển thị tam giác vuông có cạnh góc vuông ở top-left.\n" +
                "4. Hiển thị tam giác vuông có cạnh góc vuông ở botton-right.\n" +
                "5. Hiển thị tam giác vuông có cạnh góc vuông ở top-right.\n" +
                "6. Hiển thị tam giác cân.\n" +
                "Enter your choice: ");
        choice = input.nextInt();
        switch (choice){
            case 1:
                for (int i = 1; i <= 3; i++){
                    for (int j = 1; j <= 7; j++){
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            case 2:
                for(int i = 1; i <= 5; i++){
                    for(int j=1; j <= i; j++){
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
                break;
            case 3:
                for(int i = 5; i >= 1; i--){
                    for(int j = 1; j <= i; j++){
                        System.out.print("* ");
                    }
                    System.out.println(" ");
                }
                break;
            case 4:
                for(int i = 1; i <= 5; i++){
                    for(int j=1; j <= (5-i); j++){
                        System.out.print(" ");
                    }
                    for(int j=1; j <= i; j++){
                        System.out.print("* ");
                    }
                    System.out.println("* ");
                }
                break;
            case 6:
                for(int i = 1; i <= 5; i++) {
                    for(int j = 1; j <= 5-i; j++) {
                        System.out.print("  ");
                    }
                    for(int k = 1; k <= 2*i-1; k++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
        }
    }
}
