package _06_Ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle {

    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double theTich(){
        return this.getHeight() * Math.PI * super.getRadius() * super.getRadius();
    }

    @Override
    public String toString() {
        return "Cylinder{" + "radius=" + super.getRadius() +
                ", color='" + super.getColor() +
                ", height=" + height +
                '}';
    }
}
