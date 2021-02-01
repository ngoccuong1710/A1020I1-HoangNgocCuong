package _07_Abstract_class_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public class Circle implements Comparable<Circle> {
    protected double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + radius;
    }

    @Override
    public int compareTo(Circle o) {
        return (int) getArea();
    }
}
