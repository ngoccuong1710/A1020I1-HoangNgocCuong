package _01_Introduction_to_Java.bai_tap.doc_so_thanh_chu;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        System.out.println("Nhập số: ");
        Scanner sc = new Scanner(System.in);
        int donVi = 0;
        int hangChuc = 10;
        int n = sc.nextInt();
        if (n < 10 || 0 <= n){
            donVi = n;
            System.out.println(donVi);
        }
        else if (n < 20 || 10 <= n){
            hangChuc = n;
            System.out.println(hangChuc);
        }
        else if (n < 999 || 100 <= n){
            
        }
        switch (donVi){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
                break;
            case 0:
                System.out.println("nine");
                break;
        }

        switch (hangChuc){
            case 11:
                System.out.println("eleven");
                break;
            case 12:
                System.out.println("twelve");
                break;
            case 13:
                System.out.println("thirteen");
                break;
            case 14:
                System.out.println("fourteen");
                break;
            case 15:
                System.out.println("fifteen");
                break;
            case 16:
                System.out.println("sixteen");
                break;
            case 17:
                System.out.println("seventeen");
                break;
            case 18:
                System.out.println("eighteen");
                break;
            case 19:
                System.out.println("nineteen");
                break;
        }
    }

    private String hang_tram(int num){
        switch (num){
            case 1:
                return "one hundred";
            case 2:
                return "two hundred";
            case 3:
                return "three hundred";
            case 4:
                return "four hundred";
            case 5:
                return "five hundred";
            case 6:
                return "six hundred";
            case 7:
                return "seven hundred";
            case 8:
                return "eight hundred";
            case 9:
                return "nine hundred";
            default:
                return "hundred";

        }
    }
}
