package _06_Ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3, "yellow");
        System.out.println(circle);
        System.out.println("Diện tích hình trụ là: " + circle.dienTichHT());

        Cylinder cylinder = new Cylinder(4, "red", 6);
        System.out.println(cylinder);
        System.out.println("Thể tích hình trụ là: " + cylinder.theTich());
    }
}
