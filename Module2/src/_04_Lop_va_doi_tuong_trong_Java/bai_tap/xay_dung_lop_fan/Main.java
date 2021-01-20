package _04_Lop_va_doi_tuong_trong_Java.bai_tap.xay_dung_lop_fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3, 10, "Yellow");
        Fan fan2 = new Fan(2, 5, "Blue");
        fan1.setOn(true);
        fan2.setOn(false);
        System.out.println(fan1);
        System.out.println(fan2);

    }
}
