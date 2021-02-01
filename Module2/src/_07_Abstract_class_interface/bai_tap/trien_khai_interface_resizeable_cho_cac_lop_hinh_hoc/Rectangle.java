package _07_Abstract_class_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public class Rectangle implements Resizeable {
    protected double width = 1.0;
    protected double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    @Override
    public String toString() {
        return "A Rectangle with width = "
                + width
                + " and length = "
                + length;
    }

    @Override
    public void resize(double percent) {
        width *= percent / 100;
        length *= percent / 100;
    }
}
