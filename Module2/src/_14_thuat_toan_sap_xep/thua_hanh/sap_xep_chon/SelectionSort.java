package _14_thuat_toan_sap_xep.thua_hanh.sap_xep_chon;

import java.util.Scanner;

public class SelectionSort {
    public static void  selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
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
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }
}
