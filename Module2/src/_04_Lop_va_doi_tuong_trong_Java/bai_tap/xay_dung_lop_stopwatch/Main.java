package _04_Lop_va_doi_tuong_trong_Java.bai_tap.xay_dung_lop_stopwatch;

public class Main {
    public static int[] selectionSort(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[i]){
                    int tempt = a[i];
                    a[i] = a[j];
                    a[j] = tempt;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = new int [100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        selectionSort(arr);
        stopwatch.stop();
        System.out.println("Thời gian thực thi: "+stopwatch.getElapsedTime());
    }
}
