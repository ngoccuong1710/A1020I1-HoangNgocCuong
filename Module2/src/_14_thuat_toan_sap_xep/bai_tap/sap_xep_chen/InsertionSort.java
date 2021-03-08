package _14_thuat_toan_sap_xep.bai_tap.sap_xep_chen;

import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int curElement = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                if (curElement < arr[j]){
                    arr[j + 1] = arr[j];
                }
                else {
                    break;
                }
            }
            arr[j + 1] = curElement;
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
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }
}
