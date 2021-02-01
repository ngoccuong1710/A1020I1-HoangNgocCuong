package _07_Abstract_class_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public class InterfaceResizeableTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3);
        System.out.println(circle1);
        System.out.println("Area = " + circle1.getArea());

        Resizeable circle2 = new ResizeableCircle(3);
        circle2.resize(40);
        System.out.println(circle2);
    }
}
