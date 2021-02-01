package _07_Abstract_class_interface.bai_tap.trien_khai_interface_colorable_cho_cac_lop_hinh_hoc;

public class Square implements Colorable {
    protected double side1 = 1.0;
    protected double side2 = 1.0;

    public Square() {
    }

    public Square(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getArea() {
        return side1 * side2;
    }

    @Override
    public String toString() {
        return "A Square with side1 = "
                + side1
                + " and side2 = "
                + side2;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
