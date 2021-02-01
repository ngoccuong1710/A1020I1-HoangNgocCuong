package _07_Abstract_class_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public class InterfaceResizeableTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3);
        System.out.println(circle1);
        System.out.println("Area circle1 = " + circle1.getArea());

        Resizeable circle2 = new Circle(3);
        circle2.resize(40);
        System.out.println(circle2);
        System.out.println("Area circle2 = " + ((Circle) circle2).getArea());

        Rectangle rectangle1 = new Rectangle(4,6);
        System.out.println(rectangle1);
        System.out.println("Area rectangle1 = " + rectangle1.getArea());

        Resizeable rectangle2 = new Rectangle(4, 6);
        rectangle2.resize(50);
        System.out.println(rectangle2);
        System.out.println("Area rectangle2 = " + ((Rectangle) rectangle2).getArea());

        Square square1 = new Square(3, 3);
        System.out.println(square1);
        System.out.println("Area square1 = " + square1.getArea());

        Resizeable square2 = new Square(3, 3);
        square2.resize(50);
        System.out.println(square2);
        System.out.println("Area square2 = " + ((Square) square2).getArea());

    }
}
