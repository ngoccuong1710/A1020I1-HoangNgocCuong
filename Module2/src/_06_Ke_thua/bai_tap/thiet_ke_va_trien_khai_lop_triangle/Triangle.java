package _06_Ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class Triangle extends Shape{
    private String color;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3, String color) {
        super(side1, side2, side3);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return (Math.sqrt((getSide1() + getSide2() + getSide3()) * (getSide1() + getSide2() - getSide3())
                * (getSide2() + getSide3() - getSide1()) * (getSide3() + getSide1() - getSide2()))) / 4;
    }

    public double getPerimeter(){
        return getSide1() + getSide2() + getSide3();
    }

    @Override
    public String toString() {
        return "Tam giác có 3 cạnh: " + getSide1() + ", " + getSide2() + ", " + getSide3()
                + ".\nMàu: " + getColor()
                + ".\nCó diện tích là: " + getArea() + "\nChu vi là: " + getPerimeter();
    }
}
