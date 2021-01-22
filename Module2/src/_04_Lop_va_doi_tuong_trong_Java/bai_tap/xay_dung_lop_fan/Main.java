package _04_Lop_va_doi_tuong_trong_Java.bai_tap.xay_dung_lop_fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan(Fan.FAST, true, 10, "yellow");
        Fan fan2 = new Fan(Fan.MEDIUM, false, 5, "blue");
        System.out.println("Fan 1: " + fan1);
        System.out.println("Fan 1: " + fan2);
    }
}
