package _14_thuat_toan_sap_xep.thua_hanh.sap_xep_noi_bot;

import java.util.Scanner;

public class BubbleShort {
    public static void bubbleSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j <arr.length - i; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài của chuỗi ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của chuỗi ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }
}
